package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by acanaveral on 13/5/16.
 */
public class Folder extends  BaseRestModel implements Serializable{
    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;

    public Folder() {
        super("application/repository.folder+json");
    }

    public Folder(String description, String label, String uri) {
        super("application/repository.folder+json");
        this.description = description;
        this.label = label;
        this.uri = uri;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public long getPermissionMask() {
        return permissionMask;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUri() {
        return uri;
    }

    public long getVersion() {
        return version;
    }


}
