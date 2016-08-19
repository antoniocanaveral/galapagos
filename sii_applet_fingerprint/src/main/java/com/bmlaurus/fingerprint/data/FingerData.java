package com.bmlaurus.fingerprint.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by antonio on 19/08/16.
 */
public class FingerData implements Serializable{
    private int userId;
    private String identification;
    private String textData;
    private List<FingerDetail> detail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public List<FingerDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<FingerDetail> detail) {
        this.detail = detail;
    }
}
