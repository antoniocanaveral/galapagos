package com.besixplus.sii.ws;

import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.integration.SiiAttachmentDocument;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.bmlaurus.alfresco.integration.SiiPersonalesDocument;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;
import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Created by acanaveral on 4/5/16.
 * Clase Alf_push permite subir archivos al servidor y trasladarlos a Alfresco
 */
@MTOM
@WebService()
public class Alf_push implements Serializable {

    /**
     *
     * @param dh archivo enviado desde el cliente
     * @param props json con las propiedades del archivo
     * @return el resultado de la operación en json
     */
    @MTOM
    @WebMethod
    public String uploadFile(
            @WebParam(name="dh") @XmlMimeType("application/octet-stream") DataHandler dh,
            @WebParam(name="ref") String ref,
            @WebParam(name="props") String props
    ){
        String ret=null;
        Gson gson = new Gson();
        Type attachmentDocument = new TypeToken<SiiPersonalesDocument>() {}.getType();
        SiiAttachmentDocument payload = gson.fromJson(props, attachmentDocument);
        SiiFileResult result = AlfrescoActions.createFile(dh, payload);
        ret = gson.toJson(result);
        return ret;
    }
}
