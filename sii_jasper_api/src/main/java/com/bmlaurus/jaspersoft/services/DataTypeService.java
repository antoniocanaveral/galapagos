package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.JasperDataType;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 * Created by acanaveral on 1/8/16.
 */
public class DataTypeService extends BaseAPI {

    public JasperDataType getOrCreateDataType(JasperDataType dataType){
        if (dataType != null) {
            try {
                    dataType.setUri(config.getProperty("RESOURCE") + config.getProperty("SII_DATATYPES_PATH") + "/" + dataType.getLabel());
                    HttpGet get = new HttpGet();
                    get.setHeader(JasperDataType.HDR_CONTENT_TYPE, dataType.getConten_type());
                    get.setHeader("Accept", "application/json");

                    httpRes = sendRequest(get, config.getProperty("RESOURCE") + config.getProperty("SII_DATATYPES_PATH") + "/" + dataType.getLabel(), null);
                    if (validateRequest(httpRes)) {
                        if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                            releaseConnection(httpRes);
                            dataType = createDataType(dataType);
                        } else {
                            dataType = getEntity(httpRes, JasperDataType.class);
                            releaseConnection(httpRes);
                        }
                    }
            }catch(Exception e){
                log.error(e);
            }
        }
        return dataType;
    }


    private JasperDataType createDataType(JasperDataType dataType){
        if(dataType!=null) {
            dataType.setUri(config.getProperty("RESOURCE") + config.getProperty("SII_DATATYPES_PATH") + "/" + dataType.getLabel());
            try {
                HttpPut put = new HttpPut();
                put.setHeader(JasperDataType.HDR_CONTENT_TYPE, dataType.getConten_type());
                put.setHeader("Accept", "application/json");
                put.setEntity(new StringEntity(getGsonEngine().getGson().toJson(dataType)));

                httpRes = sendRequest(put, config.getProperty("RESOURCE") + config.getProperty("SII_DATATYPES_PATH") + "/" + dataType.getLabel(), null);
                if (validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                            || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        dataType = getEntity(httpRes, JasperDataType.class);
                    }
                }

            } catch (Exception e) {
                log.error(e);
            } finally {
                releaseConnection(httpRes);
            }
        }
        return dataType;
    }
}
