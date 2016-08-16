package com.bmlaurus.alfresco.integration;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Created by acanaveral on 4/5/16.
 */
public class SiiPersonalesDocument extends SiiAttachmentDocument implements Serializable{

    private static final long serialVersionUID = -1988541771138413461L;
    private final String DOCUMENT_NAME = "D:sii:personales";
    private String personal_ref;

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
