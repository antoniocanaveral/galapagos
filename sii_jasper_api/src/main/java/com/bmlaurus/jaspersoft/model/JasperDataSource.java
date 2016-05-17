package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by acanaveral on 16/5/16.
 */
public class JasperDataSource extends  BaseRestModel implements Serializable {

    private Date creationDate;
    private String description;
    private String label;
    private long permissionMask;
    private Date updateDate;
    private String uri;
    private long version;
    private String driverClass;
    private String password;
    private String username;
    private String connectionUrl;
    private String timezone;

    public JasperDataSource() {
        super("application/repository.jdbcDataSource+json");
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

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
