package com.bmlaurus.alfresco.integration;

import org.alfresco.webservice.content.Aspect;
import org.alfresco.webservice.content.AspectProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 3/5/16.
 */
public class SiiAlmacenable extends Aspect {

    private final String ASPECT_NAME = "P:"+prefix+":almacenable";

    private final String CAJA_NAME = prefix+":caja";
    private final String CARPETA_NAME = prefix+":carpeta";
    private final String DESCRIPCION_NAME = prefix+":descripcion";

    private String caja;
    private String carpeta;
    private String descripcion;

    public SiiAlmacenable(String caja, String carpeta, String descripcion) {
        this.caja = caja;
        this.carpeta = carpeta;
        this.descripcion = descripcion;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public List<AspectProperty> toProperties(){
        List<AspectProperty> properties = new ArrayList<>();
        if(caja != null)
            properties.add(new AspectProperty(ASPECT_NAME,CAJA_NAME,caja));
        if(carpeta!=null)
            properties.add(new AspectProperty(ASPECT_NAME,CARPETA_NAME,carpeta));
        if(descripcion!=null)
            properties.add(new AspectProperty(ASPECT_NAME,DESCRIPCION_NAME,descripcion));

        return properties;
    }

    @Override
    public String getAspectName() {
        return ASPECT_NAME;
    }
}
