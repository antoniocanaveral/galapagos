package com.bmlaurus.fingerprint.data;

import java.io.Serializable;

/**
 * Created by antonio on 19/08/16.
 */
public class FingerDetail implements Serializable {
    private int fingerID;
    private String fingerImg;

    public int getFingerID() {
        return fingerID;
    }

    public void setFingerID(int fingerID) {
        this.fingerID = fingerID;
    }

    public String getFingerImg() {
        return fingerImg;
    }

    public void setFingerImg(String fingerImg) {
        this.fingerImg = fingerImg;
    }
}
