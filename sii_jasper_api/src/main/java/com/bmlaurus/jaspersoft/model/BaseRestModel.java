package com.bmlaurus.jaspersoft.model;

/**
 * Created by acanaveral on 13/5/16.
 */
public abstract class BaseRestModel {
    public static final String HDR_CONTENT_TYPE="Content-Type";

    private transient String conten_type;

    public BaseRestModel(String conten_type) {
        this.conten_type = conten_type;
    }

    public String getConten_type() {
        return conten_type;
    }

    public void setConten_type(String conten_type) {
        this.conten_type = conten_type;
    }
}
