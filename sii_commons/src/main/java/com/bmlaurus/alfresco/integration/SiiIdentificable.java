package com.bmlaurus.alfresco.integration;

import com.bmlaurus.alfresco.aspects.Aspect;
import com.bmlaurus.alfresco.aspects.AspectProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 3/5/16.
 */
public class SiiIdentificable extends Aspect implements Serializable{


    private static final long serialVersionUID = 3992972689455856668L;
    private final String ASPECT_NAME = "P:"+prefix+":identificable";

    private final String TABLE_NAME_NAME = prefix+":table_name";
    private final String RECORD_ID_NAME = prefix+":record_id";

    private String table_name;
    private String record_id;

    public SiiIdentificable(String table_name, String record_id) {
        this.table_name = table_name;
        this.record_id = record_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    @Override
    public String getAspectName() {
        return ASPECT_NAME;
    }

    @Override
    public List<AspectProperty> toProperties(){
        List<AspectProperty> properties = new ArrayList<>();
        if(table_name != null)
            properties.add(new AspectProperty(ASPECT_NAME,TABLE_NAME_NAME,table_name));
        if(record_id!=null)
            properties.add(new AspectProperty(ASPECT_NAME,RECORD_ID_NAME,record_id));

        return properties;
    }
}
