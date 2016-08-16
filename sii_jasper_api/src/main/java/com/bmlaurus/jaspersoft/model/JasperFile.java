package com.bmlaurus.jaspersoft.model;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.Date;

/**
 * Created by acanaveral on 13/5/16.
 */
public class JasperFile extends  BaseRestModel implements Serializable {

    public static final String MIME_TYPE_JRXML = "jrxml";
    public static final String MIME_TYPE_IMAGE = "img";

    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;
    private String type;
    private transient File file;
    private String content;

    public JasperFile(String label, String description, String uri, File file) {
        super("application/repository.file+json");
        this.label = label;
        this.description = description;
        this.uri = uri;
        this.file = file;
        this.type = MIME_TYPE_JRXML;
        if(file!=null && file.exists()){
            populateContent();
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    private void populateContent(){

        try {
            content = encodeFile();//encodeFileToBase64Binary(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String encodeFile(){
        File originalFile = file;
        String encodedBase64 = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
            byte[] bytes = new byte[(int)originalFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedBase64;
    }
}
