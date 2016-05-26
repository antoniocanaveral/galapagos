package com.besixplus.sii.ws;

import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.bmlaurus.alfresco.integration.SiiFolderResult;
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
        String json = null;

        return json;
    }

}
