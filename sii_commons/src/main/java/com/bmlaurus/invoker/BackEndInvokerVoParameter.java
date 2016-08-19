package com.bmlaurus.invoker;

import java.io.Serializable;

/**
 * Created by HW on 8/18/16.
 */
public class BackEndInvokerVoParameter implements Serializable {

    private String url;
    private String username;
    private String password;
    private String payload;
    private String method;

    private String soapClassName;
    private String soapMethodName;


    public String getSoapClassName() {
        return soapClassName;
    }

    public void setSoapClassName(String soapClassName) {
        this.soapClassName = soapClassName;
    }

    public String getSoapMethodName() {
        return soapMethodName;
    }

    public void setSoapMethodName(String soapMethodName) {
        this.soapMethodName = soapMethodName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
