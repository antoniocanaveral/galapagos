package com.bmlaurus.jaspersoft.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 13/5/16.
 */
public class ErrorMessage implements Serializable {

    private String message;
    private String errorCode;
    private List<String> parameters;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
}
