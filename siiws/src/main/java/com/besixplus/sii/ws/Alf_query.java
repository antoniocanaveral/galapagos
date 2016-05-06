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
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebServiceContext;
import java.io.Serializable;

/**
 * Clase Alf_query: Contiene los metodos necesarios para consultar y extraer datos de Alfresco.
 * Created by acanaveral on 4/5/16.
 */
@WebService()
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
            @WebParam String path
    ){
        String ret="";
        SiiFolderResult result = AlfrescoActions.getFolderContent(path);
        ret = gson.toJson(result);
        return ret;
    }


    /**
     *
     * @param fileId Identificador del archivo en Alfresco
     * @return Devuelve toda la información relacionada con el archivo (incluye propiedades de aspectos)
     */
    public String getFullFileInfo(
            @WebParam  String fileId
    ){
        String ret="";
        SiiFileResult result = AlfrescoActions.getFileInfo(fileId);
        ret = gson.toJson(result);
        return ret;
    }

    /**
     *
     * @param fileId Identificador del archivo en Alfresco
     * @return Archivo descargado
     */
    @WebMethod
    @XmlMimeType("application/octet-stream")
    public DataHandler downloadAlfrescoFile(
            @WebParam String fileId
    ){
        DataHandler file = AlfrescoActions.getDocument(fileId);
        return file;
    }

}
