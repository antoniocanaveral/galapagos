package com.bmlaurus.alfresco.integration;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;

/**
 * Created by acanaveral on 4/5/16.
 */
public class SiiPersonalesDocument extends SiiAttachmentDocument {

    private final String DOCUMENT_NAME = "D:sii:personales";
    private String personal_ref;

    @Nullable
    public SiiPersonalesDocument(String personal_ref) {
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
        //    props.put("sii:personal_ref",personal_ref);
    }
}
