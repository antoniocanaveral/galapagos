package com.besixplus.sii.ws;

import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.integration.SiiAttachmentDocument;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.google.gson.Gson;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import java.io.Serializable;

/**
 * Created by acanaveral on 4/5/16.
 * Clase Alf_push permite subir archivos al servidor y trasladarlos a Alfresco
 */
@WebService()
public class Alf_push implements Serializable {

    /**
     *
     * @param dh archivo enviado desde el cliente
     * @param props json con las propiedades del archivo
     * @return el resultado de la operación en json
     */
    @XmlMimeType("application/octet-stream")
    public String uploadFile(
            @WebParam DataHandler dh,
            @WebParam String props
    ){
        String ret=null;
        Gson gson = new Gson();
        SiiAttachmentDocument payload = gson.fromJson(props, SiiAttachmentDocument.class);
        SiiFileResult result = AlfrescoActions.createFile(dh, payload);
        ret = gson.toJson(result);
        return ret;
    }
}
