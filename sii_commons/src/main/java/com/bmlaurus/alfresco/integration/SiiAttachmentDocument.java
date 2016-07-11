package com.bmlaurus.alfresco.integration;

import com.bmlaurus.alfresco.aspects.Aspect;
import com.bmlaurus.alfresco.aspects.AspectProperty;
import com.bmlaurus.alfresco.utils.PropertyIds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by acanaveral on 4/5/16.
 */
public abstract class SiiAttachmentDocument implements Serializable{

    private static final long serialVersionUID = 2407193988302831253L;
    private final String domain = "{com.bmlaurus.model}";
    private String path;
    private String fileName;
    private final String DOCUMENT_NAME = "D:sii:attachmentDocument";
    protected String documentName = DOCUMENT_NAME;

    protected List<Aspect> declaredAspects;

    public String getDomain() {
        return domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFullPath(){
        String path = getPath();
        if(!path.endsWith("/"))
            path = path + "/";
        path = path + getFileName();
        return path;
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
