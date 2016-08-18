package com.bmlaurus.nbio.api.export;

/**
 * Created by antonio on 18/08/16.
 */
public class ExportImgHandler {

    private int fingerID;
    private byte[] imgData;

    public ExportImgHandler(int fingerID, byte[] imgData) {
        this.fingerID = fingerID;
        this.imgData = imgData;
    }

    public int getFingerID() {
        return fingerID;
    }

    public void setFingerID(int fingerID) {
        this.fingerID = fingerID;
    }

    public byte[] getData() {
        return imgData;
    }

    public void setData(byte[] imgData) {
        this.imgData = imgData;
    }
}
