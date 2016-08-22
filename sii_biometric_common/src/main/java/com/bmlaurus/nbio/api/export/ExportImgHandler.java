package com.bmlaurus.nbio.api.export;

/**
 * Created by antonio on 18/08/16.
 */
public class ExportImgHandler {

    private int fingerID;
    private byte[] imgData;
    private String base64Img;
    private int sample;

    public ExportImgHandler(int fingerID, int sample, byte[] imgData) {
        this.fingerID = fingerID;
        this.imgData = imgData;
        this.sample = sample;
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

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }
}
