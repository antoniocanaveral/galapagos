package com.bmlaurus.alfresco.integration;

import org.alfresco.webservice.content.Aspect;
import org.alfresco.webservice.content.AspectProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acanaveral on 3/5/16.
 */
public class SiiCaducable extends Aspect {

    private final String ASPECT_NAME = "P:"+prefix+":caducable";

    private final String CADUCIDAD_NAME = prefix+":caducidad";

    private Date caducidad;

    public SiiCaducable(Date caducidad) {
        this.caducidad = caducidad;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public String getAspectName() {
        return ASPECT_NAME;
    }

    @Override
    public List<AspectProperty> toProperties(){
        List<AspectProperty> properties = new ArrayList<>();
        if(caducidad != null) {
            properties.add(new AspectProperty(ASPECT_NAME,CADUCIDAD_NAME, caducidad));
        }
        return properties;
    }
}
