package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 13/5/16.
 */
public class User extends  BaseRestModel implements Serializable {

    private String fullName;
    private String username;
    private String password;
    private String emailAddress;
    private boolean externallyDefined;
    private boolean enabled;
    private long previousPasswordChangeTime;
    private String tenantId;
    private List<Role> roles;

    public User(String fullName, String username, String password) {
        super("application/json");
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isExternallyDefined() {
        return externallyDefined;
    }

    public void setExternallyDefined(boolean externallyDefined) {
        this.externallyDefined = externallyDefined;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getPreviousPasswordChangeTime() {
        return previousPasswordChangeTime;
    }

    public void setPreviousPasswordChangeTime(long previousPasswordChangeTime) {
        this.previousPasswordChangeTime = previousPasswordChangeTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addDefaultRole(){
        Role role = new Role("ROLE_USER",false);
        if(roles==null)
            roles =  new ArrayList<>();
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", roles=" + roles +
                '}';
    }
}
