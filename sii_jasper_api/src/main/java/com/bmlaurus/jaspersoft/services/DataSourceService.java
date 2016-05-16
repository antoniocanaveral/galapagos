package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.Folder;
import com.bmlaurus.jaspersoft.model.JasperDataSource;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 * Created by acanaveral on 16/5/16.
 */
public class DataSourceService extends BaseAPI {

    public JasperDataSource getOrCreateDataSource(){
        String datasourceName = config.getProperty("SII_DATASOURCE_NAME");
        HttpResponse httpRes = null;
        JasperDataSource dataSource = null;
        if(loginToServer()){
            try {
                dataSource = new JasperDataSource();

                HttpGet get = new HttpGet();
                get.setHeader(Folder.HDR_CONTENT_TYPE,dataSource.getConten_type());
                get.setHeader("Accept", "application/json");

                httpRes = sendRequest(get, config.getProperty("RESOURCE") + config.getProperty("SII_DATASOURCE_PATH")+"/" + datasourceName,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                        releaseConnection(httpRes);
                        dataSource = createDataSource(datasourceName);
                    } else {
                        dataSource = getEntity(httpRes, JasperDataSource.class);
                        releaseConnection(httpRes);
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }

            logOut();
        }
        return dataSource;
    }


    private JasperDataSource createDataSource(String datasourceName){
        HttpResponse httpRes = null;
        JasperDataSource dataSource = null;
        try {
            dataSource = new JasperDataSource();
            dataSource.setLabel(datasourceName);
            dataSource.setDescription(config.getProperty("SII_DESCRIPTION"));
            dataSource.setUri(config.getProperty("RESOURCE") + config.getProperty("SII_DATASOURCE_PATH") + "/" + datasourceName);
            dataSource.setDriverClass(config.getProperty("SII_CLI_DRIVER"));
            dataSource.setPassword(config.getProperty("SII_CLI_PWD"));
            dataSource.setUsername(config.getProperty("SII_CLI_UNAME"));
            dataSource.setConnectionUrl(config.getProperty("SII_CLI_URL"));

            HttpPut put = new HttpPut();
            put.setHeader(Folder.HDR_CONTENT_TYPE, dataSource.getConten_type());
            put.setHeader("Accept", "application/json");
            put.setEntity(new StringEntity(getGsonEngine().getGson().toJson(dataSource)));

            httpRes = sendRequest(put, config.getProperty("RESOURCE") + config.getProperty("SII_DATASOURCE_PATH") + "/" + datasourceName,null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                        || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    dataSource = getEntity(httpRes, JasperDataSource.class);
                }
            }

        }catch (Exception e){
            log.error(e);
        }finally {
            releaseConnection(httpRes);
        }
        return dataSource;
    }
}
