package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.bmlaurus.alfresco.integration.SiiFolderResult;
import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.model.SiiModelMetadata;
import com.google.gson.Gson;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceContext;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Alf_query: Contiene los metodos necesarios para consultar y extraer datos de Alfresco.
 * Created by acanaveral on 4/5/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class Alf_query implements Serializable {

    @Resource
    WebServiceContext wctx;
    Gson gson = new Gson();

    /**
     *
     * @param path Ruta del Repositorio que se quiere consultar.
     * @return Devuelve un JSON con los archivos y directorios existentes en el path
     */
    @WebMethod
    public String getRepositoryContent(
            @WebParam(name = "path") String path
    ){
        String ret="";
        SiiFolderResult result = AlfrescoActions.getFolderContent(path);
        ret = gson.toJson(result);
        return ret;
    }


    /**
     *
     * @param fileId Identificador del archivo en Alfresco
     * @param versionInfo Si es true, tambien devuelve la informacion de las versiones.
     * @return Devuelve toda la información relacionada con el archivo (incluye propiedades de aspectos)
     */
    public String getFullFileInfo(
            @WebParam(name = "fileId")  String fileId,
            @WebParam(name = "versionInfo")  boolean versionInfo
    ){
        String ret="";
        SiiFileResult result = AlfrescoActions.getFileInfo(fileId, versionInfo);
        ret = gson.toJson(result);
        return ret;
    }

    /**
     *
     * @param fileId Identificador del archivo en Alfresco
     * @return Archivo descargado
     */
    @WebMethod
    public @XmlMimeType( "application/octet-stream" ) DataHandler downloadAlfrescoFile(
            @WebParam(name = "fileId") String fileId
    ){
        DataHandler file = AlfrescoActions.getDocument(fileId);
        return file;
    }

    /**
     *
     * @param tableName Nombre de la tabla de SII
     * @param recordID Identificador del registro
     * @param filter Filtro para la búsqueda
     * @return JSON con la estructura del modelo de Alfresco para esa ventana
     */
    @WebMethod
    public String getAttachmentMetadata(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "recordID") String recordID,
            @WebParam(name = "filter") String filter
    ){
        String json = "";
        Connection con = ManagerConnection.getConnection();
        SiiModelMetadata modelMetadata = SiiDataLoader.getAlfrescoMetadata(con,tableName,filter);
        if(modelMetadata!=null){
            //Si es de subida libre, obtenemos los archivos del repositorio
            if(!modelMetadata.isList()){
                SiiFolderResult result = AlfrescoActions.getFolderContent(modelMetadata.getFilesRepository());
                modelMetadata.setFolderResult(result);
            }else{//Si es lista de archivos, vamos poniendo los datos de los archivos en cada sitio
                Map<String,SiiFolderResult> remotePaths = new HashMap<>();
                for(SiiModelFile file:modelMetadata.getFileList()){
                    if(!remotePaths.containsKey(file.getFileRepository())){
                        SiiFolderResult result = AlfrescoActions.getFolderContent(file.getFileRepository());
                        remotePaths.put(file.getFileRepository(),result);
                    }
                    if(remotePaths.size()>0) {
                        SiiFolderResult fileFolder = remotePaths.get(file.getFileRepository());
                        if (fileFolder != null) {
                            for (SiiFileResult fileResult : fileFolder.getFiles()) {
                                if (fileResult.getName().contains(file.getFileName()))
                                    file.setFileResult(fileResult);
                            }
                        }
                    }
                }

            }
            json = gson.toJson(modelMetadata);
        }
        return json;
    }

    /**
     *
     * @param tableName Nombre de la tabla de SII
     * @param filter Filtro para la búsqueda
     * @return JSON con la lista de archivos de ese ECM_metadata
     */
    @WebMethod
    public String getLocalMetadata(
            @WebParam(name = "tableName") String tableName,
            @WebParam(name = "filter") String filter
    ){
        String json = "[]";
        Connection con = ManagerConnection.getConnection();
        SiiModelMetadata modelMetadata = SiiDataLoader.getAlfrescoMetadata(con,tableName,filter);
        if(modelMetadata!=null){
            json = gson.toJson(modelMetadata.getFileList());
        }
        return json;
    }


}
