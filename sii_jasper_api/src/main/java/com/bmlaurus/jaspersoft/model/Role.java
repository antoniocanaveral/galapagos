package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;

/**
 * Created by acanaveral on 13/5/16.
 */
public class Role implements Serializable {

    private String name;
    private boolean externallyDefined;

    public Role(String name, boolean externallyDefined) {
        this.name = name;
        this.externallyDefined = externallyDefined;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", externallyDefined=" + externallyDefined +
                '}';
    }
}
