package com.bmlaurus.alfresco.integration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 5/5/16.
 */
public class SiiFolderResult implements Serializable {

    private static final long serialVersionUID = 8059695132870822030L;

    private String name;
    private String id;
    private String remotePath;
    private List<SiiFileResult> files;

    public SiiFolderResult() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public List<SiiFileResult> getFiles() {
        return files;
    }

    public void setFiles(List<SiiFileResult> files) {
        this.files = files;
    }

    public void addFileResult(SiiFileResult fileResult){
        if(files==null)
            files = new ArrayList<>();

        files.add(fileResult);
    }
}
