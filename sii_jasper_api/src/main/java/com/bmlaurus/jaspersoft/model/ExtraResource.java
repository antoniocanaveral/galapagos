package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;

/**
 * Created by acanaveral on 17/5/16.
 */
public class ExtraResource implements Serializable{
    private String localFile;
    private String remoteFolder;
    private boolean isReport;
    private String localFolder;

    public ExtraResource() {
    }

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public String getRemoteFolder() {
        return remoteFolder;
    }

    public void setRemoteFolder(String remoteFolder) {
        this.remoteFolder = remoteFolder;
    }

    public boolean isReport() {
        return isReport;
    }

    public void setIsReport(boolean isReport) {
        this.isReport = isReport;
    }

    public String getLocalFolder() {
        return localFolder;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }
}
