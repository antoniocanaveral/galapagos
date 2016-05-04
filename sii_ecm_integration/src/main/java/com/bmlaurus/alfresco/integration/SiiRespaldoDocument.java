package com.bmlaurus.alfresco.integration;

import java.util.LinkedHashMap;

/**
 * Created by acanaveral on 4/5/16.
 */
public class SiiRespaldoDocument extends SiiAttachmentDocument {

    private final String DOCUMENT_NAME = "D:sii:respaldo";
    private String personal_ref;

    public SiiRespaldoDocument(String personal_ref) {
        documentName=DOCUMENT_NAME;
        this.personal_ref = personal_ref;
    }

    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public void createDocument(LinkedHashMap<String, Object> props) {
        super.createDocument(props);
        //Esto no funciona. Hay que ver porque.
        //if(personal_ref!=null)
        //    props.put("sii:respaldo_ref",personal_ref);
    }
}
