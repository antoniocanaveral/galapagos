package com.bmlaurus.alfresco.integration;

import com.bmlaurus.alfresco.aspects.Aspect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 5/5/16.
 */
public class SiiFileResult implements Serializable {

    private static final long serialVersionUID = -5105102670402793518L;

    private String displayName;
    private String name;
    private String id;
    private String versionLabel;
    private List<SiiFileResult> versions;
    private List<Aspect> aspects;

    public SiiFileResult(String displayName, String name, String id) {
        this.displayName = displayName;
        this.name = name;
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public List<SiiFileResult> getVersions() {
        return versions;
    }

    public void setVersions(List<SiiFileResult> versions) {
        this.versions = versions;
    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public void setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
    }

    public void addAspect(Aspect aspect){
        if(aspects==null)
            aspects = new ArrayList<>();

        aspects.add(aspect);
    }
}
