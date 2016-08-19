package com.bmlaurus.nbio.api.error;


/**
 * Created by antonio on 17/08/16.
 */
public class ErrorInterceptor {
    private int errorCode;
    private String message;

    public ErrorInterceptor(int errorCode) {
        this.errorCode = errorCode;
        System.out.println("NBioBSP Error Occured [" +errorCode + "]");
    }

    public ErrorInterceptor(String message) {
        this.message=message;
        System.out.println("BML API Error ["+message+"]");
    }

    public String getMessage() {
        return message;
    }

}
