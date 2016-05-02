package com.bmlaurus.alfresco.connection;

import com.bmlaurus.alfresco.entity.AlfFolder;
import com.bmlaurus.alfresco.entity.AlfNode;
import com.bmlaurus.alfresco.entity.AlfSessionData;
import com.bmlaurus.alfresco.entity.AlfUser;
import com.bmlaurus.alfresco.exception.ConnectionException;
import com.bmlaurus.alfresco.integration.SiiConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 28/4/16.
 */
public class AlfrescoServer extends AlfrescoConnection {

    private final String ACTION_LOGIN = "login";
    private final String ACTION_LOGOUT = "login/ticket/";
    private final String ACTION_FOLDER = "site/folder/"+ SiiConstants.SITE_NAME + "/documentLibrary/"+ SiiConstants.PARENT_FOLDER;



    public AlfrescoServer(String url, String port, String serviceUrl) {
        super(url, port, serviceUrl);
    }

    public AlfSessionData logIn(AlfUser alfrescoUser){
        AlfUser result = null;
        try {
            String res = postAction(null, gsonEngine.getGson().toJson(alfrescoUser), ACTION_LOGIN);
            result = gsonEngine.getGson().fromJson(res,AlfUser.class);
        }catch (ConnectionException ex){
            ex.printStackTrace();
        }
        return result!=null?result.getData():null;
    }

    public boolean logOut(AlfUser alfrescoUser){
        boolean ret = false;
        try{
            String res = deleteAction(alfrescoUser, alfrescoUser.getData().getTicket(), ACTION_LOGOUT);
            if(res.equals("OK"))
                ret = true;
        }catch (ConnectionException ex){
            ex.printStackTrace();
        }

        return ret;
    }

    public List<AlfFolder> createPath(AlfUser user, String path){
        List<AlfFolder> alfFolders = null;
        if(path != null){
            String[] folders = path.split("/");
            StringBuffer parentPath = new StringBuffer(ACTION_FOLDER);
            alfFolders = new ArrayList<AlfFolder>();
            for(String folder:folders){
                AlfFolder created = null;
                created = createFolder(user,parentPath.toString(),folder);
                if(created==null)
                    return null;
                parentPath.append("/");
                parentPath.append(folder);
                alfFolders.add(created);
            }
        }
        return alfFolders;
    }

    //@param: parent tiene el actionPath incluido
    public AlfFolder createFolder(AlfUser user, String parent ,String folder){
        try{
            String description = "Autogestionado por SII";
            AlfFolder alfFolder = new AlfFolder(folder,folder,description);
            AlfNode node = null;
            try {
                String res = postAction(user, gsonEngine.getGson().toJson(alfFolder), parent);
                node = (AlfNode) gsonEngine.fromJsonWithReader(res, AlfNode.class);
            }catch (RuntimeException e){
                if(e.getMessage().equals("500")){
                    //La carpeta ya existe
                    return alfFolder;
                }
            }
            if(node != null){
                alfFolder.setNode(node);
                return alfFolder;
            }
        }catch (ConnectionException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
