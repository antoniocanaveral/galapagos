package com.bmlaurus.jasper;

import java.io.Serializable;

/**
 * Created by acanaveral on 16/5/16.
 */
public class JasperResponse implements Serializable {

    private boolean result;
    private String errorMessage;
    private String errorCode;

    public JasperResponse(boolean result, String errorMessage, String errorCode) {
        this.result = result;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
