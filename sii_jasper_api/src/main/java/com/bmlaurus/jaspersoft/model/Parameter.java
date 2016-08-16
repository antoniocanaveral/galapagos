package com.bmlaurus.jaspersoft.model;

import java.util.List;

/**
 * Created by acanaveral on 9/7/16.
 */
public class Parameter{
    private String name;
    private List<String> value;

    public Parameter(String name, List<String> value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
