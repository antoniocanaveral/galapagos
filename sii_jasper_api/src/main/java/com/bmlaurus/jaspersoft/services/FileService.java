package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.JasperFile;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.File;

/**
 * Created by acanaveral on 13/5/16.
 */
public class FileService extends BaseAPI {

    public JasperFile getJasperFile(String filePath){
        if(filePath!=null && filePath.contains("-"))
            filePath=filePath.replaceAll("-","_");
        HttpResponse httpRes = null;
        JasperFile file = null;
        if(loginToServer()){
            try {
                //Buscamos el archivo
                HttpGet get = new HttpGet();
                file = new JasperFile(null,null,filePath,null);
                get.setHeader(JasperFile.HDR_CONTENT_TYPE, file.getConten_type());
                get.setHeader("Accept", "application/json");
                httpRes = sendRequest(get, config.getProperty("RESOURCE")+filePath,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        file = getEntity(httpRes, JasperFile.class);
                    }
                }
            } catch (Exception e) {
                log.error(e);
            } finally {
                releaseConnection(httpRes);
            }

            logOut();
        }
        return file;
    }


    public boolean touchFile(String filePath){
        if(filePath!=null && filePath.contains("-"))
            filePath=filePath.replaceAll("-","_");
        HttpResponse httpRes = null;
        boolean res = false;
        if(loginToServer()){
            try {
                //Buscamos el archivo
                HttpGet get = new HttpGet();
                JasperFile file = new JasperFile(null,null,filePath,null);
                get.setHeader(JasperFile.HDR_CONTENT_TYPE, file.getConten_type());
                get.setHeader("Accept", "application/json");
                httpRes = sendRequest(get, config.getProperty("RESOURCE")+filePath,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        res = true;
                    }
                }
            } catch (Exception e) {
                log.error(e);
            } finally {
                releaseConnection(httpRes);
            }

            logOut();
        }
        return res;
    }

    public boolean uploadFile(String parentPath, String name, File _file){
        HttpResponse httpRes = null;
        boolean res = false;
        if(loginToServer()){
            try {
                JasperFile file = new JasperFile(name,config.getProperty("SII_DESCRIPTION"),parentPath,_file);
                if(!_file.getName().endsWith("jrxml"))
                    file.setType(JasperFile.MIME_TYPE_IMAGE);//FIXME:Damos por echo que el resto de archivos son imagenes. No es correcto.

                HttpPost post = new HttpPost();
                post.setHeader(JasperFile.HDR_CONTENT_TYPE, file.getConten_type());
                post.setHeader("Accept", "application/json");
                post.setEntity(new StringEntity(getGsonEngine().getGson().toJson(file)));

                httpRes = sendRequest(post, config.getProperty("RESOURCE")+parentPath,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK
                            ||httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
                        res = true;
                    }
                }
            } catch (Exception e) {
                log.error(e);
            } finally {
                releaseConnection(httpRes);
            }

            logOut();
        }
        return res;
    }
}
