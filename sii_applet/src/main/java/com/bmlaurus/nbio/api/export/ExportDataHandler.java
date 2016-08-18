package com.bmlaurus.nbio.api.export;

import java.io.Serializable;

/**
 * Created by antonio on 18/08/16.
 */
public class ExportDataHandler implements Serializable{

    private int fingerID;
    private byte[] data;

    public ExportDataHandler(int fingerID, byte[] data) {
        this.fingerID = fingerID;
        this.data = data;
    }

    public int getFingerID() {
        return fingerID;
    }

    public void setFingerID(int fingerID) {
        this.fingerID = fingerID;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
