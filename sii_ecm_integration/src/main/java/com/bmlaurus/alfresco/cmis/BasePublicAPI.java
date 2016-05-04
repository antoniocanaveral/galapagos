package com.bmlaurus.alfresco.cmis;

import com.bmlaurus.alfresco.integration.SiiAttachmentDocument;
import com.bmlaurus.alfresco.model.ContainerEntry;
import com.bmlaurus.alfresco.model.ContainerList;
import com.bmlaurus.alfresco.model.NetworkEntry;
import com.bmlaurus.alfresco.model.NetworkList;
import com.bmlaurus.alfresco.utils.Config;
import com.google.api.client.http.*;
import org.alfresco.webservice.content.Aspect;
import org.apache.chemistry.opencmis.client.api.*;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by acanaveral on 28/4/16.
 */

public abstract class BasePublicAPI {
    public static final String SITES_URL = "/public/alfresco/versions/1/sites/";
    public static final String NODES_URL = "/public/alfresco/versions/1/nodes/";

    private String homeNetwork;

    /**
     * Use the CMIS API to get a handle to the root folder of the
     * target site, then create a new folder, then create
     * a new document in the new folder
     *
     * @param cmisSession
     * @param parentFolderId
     * @param folderName
     * @return Folder
     *
     * @author jpotts
     *
     */
    public Folder createFolder(String parentFolderId, String folderName) {
        Session cmisSession = getCmisSession();
        Folder rootFolder = (Folder) cmisSession.getObject(parentFolderId);

        Folder subFolder = null;
        try {
            // Making an assumption here that you probably wouldn't normally do
            subFolder = (Folder) cmisSession.getObjectByPath(rootFolder.getPath() + "/" + folderName);
            System.out.println("Folder already exists!");
        } catch (CmisObjectNotFoundException onfe) {
            LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
            props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder,P:cm:titled");
            props.put(PropertyIds.NAME, folderName);
            subFolder = rootFolder.createFolder(props);
            Aspect.addAspectProperty(props, "P:cm:titled", "cm:description", getDefaultDescription());
            String subFolderId = subFolder.getId();
            System.out.println("Created new folder: " + subFolderId);
        }

        return subFolder;
    }


    public java.util.List<Folder> createFoldersByPath(String parentFolderId, String path){
        Session cmisSession = getCmisSession();
        //Inicializamos con el contenedor
        Folder rootFolder = (Folder) cmisSession.getObject(parentFolderId);
        StringBuffer parentPath = new StringBuffer(rootFolder.getPath());

        java.util.List<Folder> folders = new ArrayList<Folder>();
        String[] _folders = path.split("/");

        for(String folder: _folders) {
            Folder subFolder = null;
            //cambiamos rootFolder al repo anterior
            rootFolder = (Folder) cmisSession.getObjectByPath(parentPath.toString());
            try {
                parentPath.append("/"+folder);
                // Making an assumption here that you probably wouldn't normally do
                subFolder = (Folder) cmisSession.getObjectByPath(parentPath.toString());
                System.out.println("Folder already exists!");
            } catch (CmisObjectNotFoundException onfe) {
                LinkedHashMap<String, Object> props = new LinkedHashMap<String, Object>();
                props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
                props.put(PropertyIds.NAME, folder);
                Aspect.addAspectProperty(props, "P:cm:titled", "cm:description", getDefaultDescription());
                Aspect.addAspectProperty(props, "P:cm:titled", "cm:title", folder);
                subFolder = rootFolder.createFolder(props);
                String subFolderId = subFolder.getId();
                System.out.println("Created new folder: " + subFolderId);
            }
            folders.add(subFolder);
        }
        return folders;
    }

    private void updateSecondaryType(Folder folder, String aspectId, String propertyId, String propertyValue){
        List aspects = folder.getProperty(PropertyIds.SECONDARY_OBJECT_TYPE_IDS).getValues();
        if (!aspects.contains(aspectId)) {
            aspects.add(aspectId);
            HashMap props_aspects = new HashMap();
            props_aspects.put(PropertyIds.SECONDARY_OBJECT_TYPE_IDS, aspects);
            folder.updateProperties(props_aspects);
            System.out.println("Aspect added");
        } else {
            System.out.println("Object already has aspect");
        }

        HashMap props_aspects = new HashMap();
        props_aspects.put(propertyId, propertyValue);
        folder.updateProperties(props_aspects);
    }

    public String getHomeNetwork() throws IOException {
        if (this.homeNetwork == null) {
            GenericUrl url = new GenericUrl(getAlfrescoAPIUrl());

            HttpRequest request = getRequestFactory().buildGetRequest(url);

            NetworkList networkList = request.execute().parseAs(NetworkList.class);
            System.out.println("Found " + networkList.list.pagination.totalItems + " networks.");
            for (NetworkEntry networkEntry : networkList.list.entries) {
                if (networkEntry.entry.homeNetwork) {
                    this.homeNetwork = networkEntry.entry.id;
                }
            }

            if (this.homeNetwork == null) {
                this.homeNetwork = "-default-";
            }

            System.out.println("Your home network appears to be: " + homeNetwork);
        }
        return this.homeNetwork;
    }

    public Document createDocument(Folder parentFolder,
                                   File file,
                                   String fileType, SiiAttachmentDocument aspect)
            throws FileNotFoundException {
        return createDocument(parentFolder, file, fileType, null, aspect);
    }

    public CmisObject getObjectByPath(String path) throws IOException {
        CmisObject obj = null;
        Session cmisSession = getCmisSession();
        String rootFolderId = getRootFolderId(getSite());
        Folder rootFolder = (Folder) cmisSession.getObject(rootFolderId);
        try{
            obj = cmisSession.getObjectByPath(rootFolder.getPath()+"/"+path);
        }catch (CmisObjectNotFoundException ex){
            obj = null;
        }
        return obj;
    }

    public List<CmisObject> getObjectsByPath(String path){
        List<CmisObject> objs = null;
        Session cmisSession = getCmisSession();
        try{
            String rootFolderId = getRootFolderId(getSite());
            Folder rootFolder = (Folder) cmisSession.getObject(rootFolderId);

            CmisObject obj = cmisSession.getObjectByPath(rootFolder.getPath()+"/"+path);
            objs = new ArrayList<>();
            if(obj instanceof Document)
                throw new CmisObjectNotFoundException("Path: "+ path +" must be a Folder");
            for(CmisObject child :((Folder) obj).getChildren()){
                objs.add(child);
            }
        }catch (CmisObjectNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objs;
    }


    /**
     * Use the CMIS API to create a document in a folder
     *
     * @param cmisSession
     * @param parentFolder
     * @param file
     * @param fileType
     * @param props
     * @return
     * @throws FileNotFoundException
     *
     * @author jpotts
     *
     */
    public Document createDocument(Folder parentFolder,
                                   File file,
                                   String fileType,
                                   LinkedHashMap<String, Object> props, SiiAttachmentDocument aspect)
            throws FileNotFoundException {

        Session cmisSession = getCmisSession();

        String fileName = file.getName();

        // create a map of properties if one wasn't passed in
        if (props == null) {
            props = new LinkedHashMap<String, Object>();
        }

        // Add the object type ID if it wasn't already
        if (props.get("cmis:objectTypeId") == null) {
            props.put("cmis:objectTypeId",  "cmis:document");
        }

        // Add the name if it wasn't already
        if (props.get("cmis:name") == null) {
            props.put("cmis:name", fileName);
        }

        Aspect.addAspectProperty(props, "P:cm:titled", "cm:description", getDefaultDescription());

        if(aspect!=null){
            aspect.createDocument(props);
        }

        ContentStream contentStream = cmisSession.getObjectFactory().
                createContentStream(
                        fileName,
                        file.length(),
                        fileType,
                        new FileInputStream(file)
                );

        Document document = null;
        try {
            document = parentFolder.createDocument(props, contentStream, null);
            System.out.println("Created new document: " + document.getId());
        } catch (CmisContentAlreadyExistsException ccaee) {
            document = (Document) cmisSession.getObjectByPath(parentFolder.getPath() + "/" + fileName);
            System.out.println("Document already exists: " + fileName);
        }

        return document;
    }


    public void updateDocument(Document doc, File file, SiiAttachmentDocument aspect){
        Session cmisSession = getCmisSession();
        List<Property<?>> list = doc.getProperties();
        LinkedHashMap<String, Object> props = new LinkedHashMap<>();
        for (Property<?> i : list) props.put(i.getId(),i.getValue());
        props.put(PropertyIds.IS_LATEST_MAJOR_VERSION,true);
        Aspect.addAspectProperty(props, "P:cm:titled", "cm:description", getDefaultDescription());

        if(aspect!=null){
            aspect.createDocument(props);
            doc.updateProperties(props);
        }
        try {
            ContentStream contentStream = cmisSession.getObjectFactory().
                    createContentStream(
                            doc.getName(),
                            file.length(),
                            (String) props.get(PropertyIds.OBJECT_TYPE_ID),
                            new FileInputStream(file)
                    );
            doc.appendContentStream(contentStream,true);
            System.out.println("Document Updated V: "+doc.getVersionLabel() +" Id: " + doc.getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use the REST API to find the documentLibrary folder for
     * the target site
     * @return String
     *
     * @author jpotts
     *
     */
    public String getRootFolderId(String site) throws IOException {

        GenericUrl containersUrl = new GenericUrl(getAlfrescoAPIUrl() +
                getHomeNetwork() +
                SITES_URL +
                site +
                "/containers");
        System.out.println(containersUrl);
        HttpRequest request = getRequestFactory().buildGetRequest(containersUrl);
        ContainerList containerList = request.execute().parseAs(ContainerList.class);
        String rootFolderId = null;
        for (ContainerEntry containerEntry : containerList.list.entries) {
            if (containerEntry.entry.folderId.equals("documentLibrary")) {
                rootFolderId = containerEntry.entry.id;
                break;
            }
        }
        return rootFolderId;
    }

    /**
     * Use the REST API to "like" an object
     *
     * @param requestFactory
     * @param homeNetwork
     * @param objectId
     * @throws IOException
     */
    public void like(String objectId) throws IOException {
        GenericUrl likeUrl = new GenericUrl(getAlfrescoAPIUrl() +
                getHomeNetwork() +
                NODES_URL +
                objectId +
                "/ratings");
        HttpContent body = new ByteArrayContent("application/json", "{\"id\": \"likes\", \"myRating\": true}".getBytes());
        HttpRequest request = getRequestFactory().buildPostRequest(likeUrl, body);
        request.execute();
        System.out.println("You liked: " + objectId);
    }

    /**
     * Use the REST API to comment on an object
     *
     * @param requestFactory
     * @param homeNetwork
     * @param objectId
     * @param comment
     * @throws IOException
     */
    public void comment(String objectId, String comment) throws IOException {
        GenericUrl commentUrl = new GenericUrl(getAlfrescoAPIUrl() +
                getHomeNetwork() +
                NODES_URL +
                objectId +
                "/comments");
        HttpContent body = new ByteArrayContent("application/json",
                ("{\"content\": \"" + comment + "\"}").getBytes());
        HttpRequest request = getRequestFactory().buildPostRequest(commentUrl, body);
        request.execute();
        System.out.println("You commented on: " + objectId);
    }

    public String getSite() {
        return Config.getConfig().getProperty("site");
    }

    public String getFolderName() {
        return Config.getConfig().getProperty("folder_name");
    }

    public File getLocalFile() {
        String filePath = Config.getConfig().getProperty("local_file_path");
        return new File(filePath);
    }

    public String getLocalFileType() {
        return Config.getConfig().getProperty("local_file_type");
    }

    abstract public String getAlfrescoAPIUrl();
    abstract public Session getCmisSession();
    abstract public HttpRequestFactory getRequestFactory();
    abstract public String getDefaultDescription();
}
