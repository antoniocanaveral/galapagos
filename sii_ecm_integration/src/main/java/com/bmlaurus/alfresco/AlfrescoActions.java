package com.bmlaurus.alfresco;

import com.bmlaurus.alfresco.aspects.Aspect;
import com.bmlaurus.alfresco.cmis.BaseAPI;
import com.bmlaurus.alfresco.integration.*;
import org.apache.chemistry.opencmis.client.api.*;
import org.apache.chemistry.opencmis.client.runtime.DocumentImpl;
import org.apache.chemistry.opencmis.client.runtime.FolderImpl;
import org.apache.chemistry.opencmis.commons.definitions.PropertyDefinition;

import javax.activation.DataHandler;
import java.io.IOException;
import java.util.*;

/**
 * Created by acanaveral on 5/5/16.
 */
public class AlfrescoActions {

    public static SiiFileResult createFile(DataHandler file, SiiAttachmentDocument document){
        SiiFileResult result = null;
        BaseAPI cmis = new BaseAPI();
        try {
            CmisObject obj = cmis.getObjectByPath(document.getFullPath());
            if(obj != null) {
                if (obj instanceof Document) {
                    cmis.updateDocument((Document) obj,file, document);
                } else{
                    System.out.println("Object :"+obj.getType().getId());
                }
            }else{
                String rootFolderId = cmis.getRootFolderId(cmis.getSite());
                // Create a new folder in the root folder
                List<Folder> subFolder = cmis.createFoldersByPath(rootFolderId, document.getPath());
                obj = cmis.createDocument(subFolder.get(subFolder.size() - 1), file, file.getContentType(), null,document);
            }
            if(obj!=null){
                result = new SiiFileResult(obj.getType().getDisplayName(),obj.getName(),obj.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static SiiFolderResult getFolderContent(String path){
        SiiFolderResult result = new SiiFolderResult();

        BaseAPI cmis = new BaseAPI();
        FolderImpl folderBase = null;

        try {
            folderBase = (FolderImpl) cmis.getObjectByPath(path);
            result.setId(folderBase.getId());
            result.setName(folderBase.getName());
            result.setRemotePath(folderBase.getPath());
            for(CmisObject obj:cmis.getObjectsById(folderBase.getId())){
                SiiFileResult file = new SiiFileResult(obj.getType().getDisplayName(),obj.getName(),obj.getId());
                result.addFileResult(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static SiiFileResult getFileInfo(String fileId, boolean versionInfo){
        BaseAPI cmis = new BaseAPI();
        SiiFileResult result = null;
        try {
            DocumentImpl obj = (DocumentImpl) cmis.getObjectById(fileId);
            if (obj != null) {
                result = new SiiFileResult(obj.getName(), obj.getName(), obj.getId());
                result.setVersionLabel(obj.getVersionLabel());
                //Consultamos Versiones
                if(versionInfo){
                    List<SiiFileResult> versions = new ArrayList<>();
                    for(Document ver: obj.getAllVersions()){
                        SiiFileResult version = new SiiFileResult(ver.getType().getDisplayName(),ver.getName(),ver.getId());
                        version.setAspects(buildAspects((DocumentImpl) ver));
                        version.setVersionLabel(ver.getVersionLabel());
                        versions.add(version);
                    }
                    result.setVersions(versions);
                }
                //Consultamos Aspectos y Propiedades
                result.setAspects(buildAspects(obj));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static DataHandler getDocument(String fileId){
        BaseAPI cmis = new BaseAPI();
        return cmis.getDocument(fileId);
    }

    private static List<Aspect> buildAspects(DocumentImpl obj){
        List<Aspect> aspects = new ArrayList<>();
        for(SecondaryType type:obj.getSecondaryTypes()){
            if(type.getId().startsWith("P:sii:")) {
                Aspect aspect = null;
                if(type.getQueryName().equals("sii:almacenable")){
                    aspect = new SiiAlmacenable(null,null,null);
                    for (PropertyDefinition prop : type.getPropertyDefinitions().values()) {
                        if (prop.getId().startsWith("sii:caja"))
                            ((SiiAlmacenable) aspect).setCaja((String) findProperty(obj,prop.getId()));
                        else if(prop.getId().startsWith("sii:carpeta"))
                            ((SiiAlmacenable) aspect).setCarpeta((String) findProperty(obj, prop.getId()));
                        else if(prop.getId().startsWith("sii:descripcion"))
                            ((SiiAlmacenable) aspect).setDescripcion((String) findProperty(obj, prop.getId()));
                    }
                }else if(type.getQueryName().equals("sii:identificable")){
                    aspect = new SiiIdentificable(null,null);
                    for (PropertyDefinition prop : type.getPropertyDefinitions().values()) {
                        if (prop.getId().startsWith("sii:record_id"))
                            ((SiiIdentificable) aspect).setRecord_id((String) findProperty(obj, prop.getId()));
                        else if (prop.getId().startsWith("sii:table_name"))
                            ((SiiIdentificable) aspect).setTable_name((String) findProperty(obj, prop.getId()));
                    }
                }else if(type.getQueryName().equals("sii:caducable")){
                    aspect = new SiiCaducable(null);
                    for (PropertyDefinition prop : type.getPropertyDefinitions().values()) {
                        if (prop.getId().startsWith("sii:caducidad")) {
                            GregorianCalendar calendar = (GregorianCalendar) findProperty(obj, prop.getId());
                            ((SiiCaducable) aspect).setCaducidad(new Date(calendar.getTimeInMillis()));
                        }
                    }
                }
                if(aspect!=null)
                    aspects.add(aspect);
            }
        }
        return aspects;
    }

    private static Object findProperty(DocumentImpl file, String propertyKey){
        Object property = null;

        for(Property prop: file.getProperties()){
            if(prop.getId().equals(propertyKey))
                property = prop.getValue();
        }

        return property;
    }
}
