package com.bmlaurus.alfresco.integration;

import org.alfresco.webservice.content.Aspect;
import org.alfresco.webservice.content.AspectProperty;
import org.apache.chemistry.opencmis.commons.PropertyIds;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by acanaveral on 4/5/16.
 */
public abstract class SiiAttachmentDocument {
    private final String domain = "{com.bmlaurus.model}";

    private final String DOCUMENT_NAME = "D:sii:attachmentDocument";
    protected String documentName = DOCUMENT_NAME;

    protected List<Aspect> declaredAspects;

    public String getDomain() {
        return domain;
    }

    public abstract String getDocumentName();

    public void addAspect(Aspect aspect){
        if(declaredAspects==null)
            declaredAspects = new ArrayList<>();

        declaredAspects.add(aspect);
    }


    public void createDocument(LinkedHashMap<String, Object> props){
        //Definimos el documento
        props.replace(PropertyIds.OBJECT_TYPE_ID, getDocumentName());

        //Verificamos aspectos y agregamos propiedades
        if(declaredAspects!=null){
            for(Aspect aspect:declaredAspects){
                for(AspectProperty property:aspect.toProperties()){
                    Aspect.addAspectProperty(props,aspect.getAspectName(),property.getName(),property.getValue());
                }
            }
        }
    }

}
