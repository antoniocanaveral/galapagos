package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;

/**
 * Created by acanaveral on 7/6/16.
 */
public class JasperReportResource implements Serializable {

    private static final long serialVersionUID = -6768563389424606267L;

    private String name;
    private ResourceFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceFile getFile() {
        return file;
    }

    public void setFile(ResourceFile file) {
        this.file = file;
    }

    public JasperReportResource(String name, String uri) {
        this.name = name;
        if(uri.contains("-"))
            uri = uri.replace("-","_");
        this.file = new ResourceFile(uri);
    }

    private class ResourceFile implements Serializable{
        private FileReference fileReference;

        public ResourceFile(String uri) {
            this.fileReference = new FileReference(uri);
        }
    }

    private class FileReference implements Serializable{
        private String uri;

        public FileReference(String uri) {
            this.uri = uri;
        }
    }
}
