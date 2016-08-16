package com.bmlaurus.alfresco.entity;

import org.apache.commons.codec.binary.Base64;

import java.io.Serializable;


/**
 * Created by acanaveral on 27/4/16.
 */
public class AlfUser implements Serializable {

    private String username;
    private String password;
    private AlfSessionData data;

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

    public AlfSessionData getData() {
        return data;
    }

    public void setData(AlfSessionData data) {
        this.data = data;
    }

    public String authBase64(){
        return Base64.encodeBase64String( (new String(username+":"+password)).getBytes()).trim();
    }
}
