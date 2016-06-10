package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.JasperReport;
import com.bmlaurus.jaspersoft.model.JasperReport.DataSource;
import com.bmlaurus.jaspersoft.model.JasperReport.Jrxml;
import com.bmlaurus.jaspersoft.model.JasperReport.Resource;
import com.bmlaurus.jaspersoft.model.JasperReportResource;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.util.List;

import static com.bmlaurus.jaspersoft.model.JasperReport.HDR_CONTENT_TYPE;

/**
 * Created by acanaveral on 16/5/16.
 */
public class JasperService extends BaseAPI {

    public JasperReport getOrCreateJasperReport(String parentPath, String reportName,  List<JasperReportResource> resourceList){
        return getOrCreateJasperReport(config.getProperty("SII_REPORTS_PATH"),parentPath,reportName,resourceList);
    }


    public JasperReport getOrCreateJasperReport(String basePath, String parentPath, String reportName,  List<JasperReportResource> resourceList){
        HttpResponse httpRes = null;
        JasperReport result = null;
        if(loginToServer()){
            try {
                if(parentPath.equals("sii") && basePath.equals(config.getProperty("SII_REPORTS_PATH")))
                    parentPath="";
                //Buscamos la carpeta
                HttpGet get = new HttpGet();
                JasperReport jasper = new JasperReport();
                get.setHeader(HDR_CONTENT_TYPE,jasper.getConten_type());
                get.setHeader("Accept", "application/json");
                httpRes = sendRequest(get, config.getProperty("RESOURCE") + basePath +"/"+ parentPath + (parentPath.isEmpty()?"":"/") +reportName,null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
                        releaseConnection(httpRes);
                        result = createJasperReport(basePath, parentPath, reportName, resourceList);
                    } else {
                        result = getEntity(httpRes, JasperReport.class);
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

    private JasperReport createJasperReport(String basePath, String parentPath, String reportName, List<JasperReportResource> resourceList){
        HttpResponse httpRes = null;
        JasperReport result = null;
        try {
            //Buscamos la carpeta
            HttpPut put = new HttpPut();
            JasperReport jasper = new JasperReport();
            jasper.setLabel(reportName);
            jasper.setDescription(config.getProperty("SII_DESCRIPTION"));
            jasper.setDataSource(new DataSource(config.getProperty("SII_DATASOURCE_PATH") + "/" + config.getProperty("SII_DATASOURCE_NAME")));
            if(resourceList!=null && resourceList.size()>0) {
                Resource res = new Resource();
                res.addResources(resourceList);
                jasper.setResources(res);
            }
            jasper.setJrxml(new Jrxml(config.getProperty("SII_RESOURCES_PATH") + "/" + (parentPath.equals("sii") ? "": parentPath) + (parentPath.isEmpty()||parentPath.equals("sii") ? "" : "/") + reportName + ".jrxml"));
            jasper.setUri(config.getProperty("RESOURCE") + basePath +"/"+ parentPath + (parentPath.isEmpty() ? "" : "/") + reportName);

            put.setHeader(HDR_CONTENT_TYPE, jasper.getConten_type());
            put.setHeader("Accept", "application/json");
            put.setEntity(new StringEntity(getGsonEngine().getGson().toJson(jasper)));
            httpRes = sendRequest(put, config.getProperty("RESOURCE") + basePath +"/"+ parentPath + (parentPath.isEmpty()?"":"/") +reportName,null);
            if(validateRequest(httpRes)) {
                if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
                        || httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = getEntity(httpRes, JasperReport.class);
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
