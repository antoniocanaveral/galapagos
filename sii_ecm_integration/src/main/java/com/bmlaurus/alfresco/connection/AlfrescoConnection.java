package com.bmlaurus.alfresco.connection;

import com.bmlaurus.alfresco.entity.AlfUser;
import com.bmlaurus.alfresco.exception.ConnectionException;
import com.bmlaurus.utils.GsonEngine;
import com.bmlaurus.utils.GsonEngineImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by acanaveral on 27/4/16.
 */
public abstract class AlfrescoConnection {

    private String url;
    private String port;
    private String serviceUrl;

    protected static GsonEngine gsonEngine;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public AlfrescoConnection(String url, String port, String serviceUrl) {
        this.url = url;
        this.port = port;
        this.serviceUrl = serviceUrl;
        //Inicialidar GsonEngine
        gsonEngine = new GsonEngineImp();
    }

    protected String postAction(AlfUser user, String payload, String actionPath) throws ConnectionException, RuntimeException {
        StringBuffer response = null;
        if(serviceUrl != null && url!= null && port != null){
            String _urlBuilder = url+":"+port+serviceUrl+actionPath;
            try {
                URL targetUrl = new URL(_urlBuilder);

                HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                httpConnection.setRequestProperty("Content-Type", "application/json");
                httpConnection.setRequestProperty("Accept", "application/json");
                httpConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                if(user!=null)
                    httpConnection.setRequestProperty("Authorization", "Basic " + user.authBase64());

                OutputStream outputStream = httpConnection.getOutputStream();
                outputStream.write(payload.getBytes());
                outputStream.flush();

                if (httpConnection.getResponseCode() != 200) {
                    throw new RuntimeException(""+httpConnection.getResponseCode());
                }

                BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                        (httpConnection.getInputStream())));

                String output;
                response = new StringBuffer();
                while ((output = responseBuffer.readLine()) != null) {
                    response.append(output);
                }

                httpConnection.disconnect();

            }catch (IOException e){
                throw new ConnectionException(e.getMessage());
            }
        }else{
            throw new ConnectionException("ServiceURL, URL or PORT can not be null");
        }

        return response!=null?response.toString():null;
    }

    protected String deleteAction(AlfUser user, String appendPayLoad, String actionPath) throws ConnectionException{
        StringBuffer response = null;
        if(serviceUrl != null && url!= null && port != null){
            //String _urlBuilder = url+":"+port+serviceUrl+"login/ticket/"+user.getData().getTicket();
            String _urlBuilder = url+":"+port+serviceUrl+actionPath+appendPayLoad;
            try {
                URL targetUrl = new URL(_urlBuilder);

                HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
                httpConnection.setRequestMethod("DELETE");
                httpConnection.setRequestProperty("Authorization", "Basic " + user.authBase64());
                httpConnection.setDoOutput(true);

                if (httpConnection.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + httpConnection.getResponseCode());
                }

                response = new StringBuffer();
                response.append(httpConnection.getResponseMessage());

                httpConnection.disconnect();

            }catch (IOException e){
                throw new ConnectionException(e.getMessage());
            }
        }else{
            throw new ConnectionException("ServiceURL, URL or PORT can not be null");
        }

        return response!=null?response.toString():null;
    }

}
