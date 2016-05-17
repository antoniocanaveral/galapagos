package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.Folder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 * Created by acanaveral on 13/5/16.
 */
public class FolderService extends BaseAPI{

    public Folder getOrCreateFolder(String path, String name){
        HttpResponse httpRes = null;
        Folder result = null;
        if(loginToServer()){
            try {
                //Buscamos la carpeta
                HttpGet get = new HttpGet();
                Folder folder = new Folder(null,null,path);
                get.setHeader(Folder.HDR_CONTENT_TYPE,folder.getConten_type());
                get.setHeader("Accept", "application/json");
                httpRes = sendRequest(get, config.getProperty("RESOURCE")+path,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                        releaseConnection(httpRes);
                        result = createFolder(path, name);
                    } else {
                        result = getEntity(httpRes, Folder.class);
                        releaseConnection(httpRes);
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }

            logOut();
        }
        return  result;
    }

    private Folder createFolder(String path, String name){
        HttpResponse httpRes = null;
        Folder result = null;
        try {
            //Buscamos la carpeta
            HttpPut put = new HttpPut();
            Folder folder = new Folder(config.getProperty("SII_DESCRIPTION"),name,path);
            put.setHeader(Folder.HDR_CONTENT_TYPE,folder.getConten_type());
            put.setHeader("Accept", "application/json");
            put.setEntity(new StringEntity(getGsonEngine().getGson().toJson(folder)));
            httpRes = sendRequest(put, config.getProperty("RESOURCE")+path,null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                        || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = getEntity(httpRes, Folder.class);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }finally {
            releaseConnection(httpRes);
        }
        return  result;
    }
}
