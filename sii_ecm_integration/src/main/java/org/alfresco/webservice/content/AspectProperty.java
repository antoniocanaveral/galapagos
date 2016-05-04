package org.alfresco.webservice.content;

import java.io.Serializable;

/**
 * Created by acanaveral on 3/5/16.
 */
public class AspectProperty {

    private String aspect;

    private String name;
    private Serializable value;


    public AspectProperty(String aspect, String name, Serializable value) {
        this.aspect = aspect;
        this.name = name;
        this.value = value;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }
}
