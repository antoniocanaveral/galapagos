package com.bmlaurus.alfresco;

import com.bmlaurus.alfresco.cmis.BaseAPI;
import com.bmlaurus.alfresco.integration.SiiAttachmentDocument;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.bmlaurus.alfresco.integration.SiiFolderResult;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;

import javax.activation.DataHandler;
import java.io.IOException;
import java.util.List;

/**
 * Created by acanaveral on 5/5/16.
 */
public class AlfrescoActions {

    public static SiiFileResult createFile(DataHandler file, SiiAttachmentDocument document){
        SiiFileResult result = new SiiFileResult();

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
                cmis.createDocument(subFolder.get(subFolder.size() - 1), file, file.getContentType(), null,document);
            }

            //TODO: Generar respuesta
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static SiiFolderResult getFolderContent(String path){
        SiiFolderResult result = null;

        BaseAPI cmis = new BaseAPI();
        StringBuffer objs = new StringBuffer();

        for(CmisObject obj:cmis.getObjectsByPath(path)){
            objs.append("Type: "+obj.getType().getDisplayName()+ " - Name: "+ obj.getName()+ " - Id: " + obj.getId() + "\n");
        }
        //TODO: Generar respuesta
        return result;
    }

    public static SiiFileResult getFileInfo(String fileId){
        SiiFileResult result = new SiiFileResult();
        BaseAPI cmis = new BaseAPI();
        CmisObject obj = cmis.getObjectById(fileId);
        if(obj!=null){
            if(obj instanceof Document){
                //TODO: Generar respuesta
                ;
            }
        }
        return result;
    }

    public static DataHandler getDocument(String fileId){
        BaseAPI cmis = new BaseAPI();
        return cmis.getDocument(fileId);
    }

}
