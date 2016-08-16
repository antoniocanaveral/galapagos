package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by acanaveral on 26/6/16.
 */
public class InputControl extends  BaseRestModel implements Serializable {

    private String id;
    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;

    private boolean mandatory;
    private boolean readOnly;
    private boolean visible;
    private String type;
    private DataTypeReference dataType;




    public InputControl() {
        super("application/repository.inputControl+json");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getPermissionMask() {
        return permissionMask;
    }

    public void setPermissionMask(long permissionMask) {
        this.permissionMask = permissionMask;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getType() {
        return type;
    }

    public void resolveType(String className) {
        /*switch (className){
            case "java.lang.String":
                type = "singleValueText";
                break;
            case "java.util.Date":
                type = "singleValueDate";
                break;
            case "java.util.Time":
                type = "singleValueTime";
                break;
            case "java.sql.Timestamp":
                type = "singleValueDatetime";
                break;
            case "java.lang.Integer":
                type = "singleValueNumber";
                break;
            case "java.lang.Long":
                type = "singleValueNumber";
                break;
            default:
                type = "singleValueText";
                break;
        }*/
        type = "2";
    }

    public DataTypeReference getDataType() {
        return dataType;
    }

    public void resolveDataType(String className) {
        String basePath = "/Datatypes/sii/";
        switch (className){
            case "java.lang.String":
                dataType = new DataTypeReference(basePath+"string");
                break;
            case "java.util.Date":
                dataType = new DataTypeReference(basePath+"dateDT");
                break;
            case "java.util.Time":
                dataType = new DataTypeReference(basePath+"dateDT");
                break;
            case "java.sql.Timestamp":
                dataType = new DataTypeReference(basePath+"dateDT");
                break;
            case "java.lang.Integer":
                dataType = new DataTypeReference(basePath+"number");
                break;
            case "java.lang.Long":
                dataType = new DataTypeReference(basePath+"number");
                break;
            default:
                dataType = new DataTypeReference(basePath+"string");
                break;
        }
    }

    private class DataTypeReference implements Serializable{
        private UriData dataTypeReference;

        public DataTypeReference(String uri) {
            dataTypeReference = new UriData(uri);
        }

        private class UriData implements Serializable{
            private String uri;

            public UriData(String uri) {
                this.uri = uri;
            }
        }
    }
}
