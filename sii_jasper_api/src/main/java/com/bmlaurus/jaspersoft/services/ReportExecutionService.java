package com.bmlaurus.jaspersoft.services;

import com.bmlaurus.jaspersoft.BaseAPI;
import com.bmlaurus.jaspersoft.model.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 9/7/16.
 */
public class ReportExecutionService extends BaseAPI {


    public ReportExecutionResponse prepareReport(Map<String,String> reportParameters, String reportFolder, String reportName){

        ReportExecutionResponse response = null;
        HttpResponse httpRes = null;
        if(loginToServer()) {
            try {
                ReportExecution execution = new ReportExecution();
                List<Parameter> params = new ArrayList<>();
                for(Map.Entry<String,String> entry:reportParameters.entrySet()){
                    List<String> paramValue = new ArrayList<>();
                    paramValue.add(entry.getValue());
                    params.add(new Parameter(entry.getKey(), paramValue));
                }
                if(params!=null && params.size()>0)
                    execution.setParameters(new ReportParameters(params));
                execution.setReportUnitUri(config.getProperty("SII_REPORTS_PATH")+"/"+reportFolder+"/"+reportName);
                HttpPost post = new HttpPost();
                post.setHeader(ReportExecution.HDR_CONTENT_TYPE, "application/json");
                post.setHeader("Accept", execution.getConten_type());
                post.setEntity(new StringEntity(getGsonEngine().getGson().toJson(execution), "UTF-8"));
                httpRes = sendRequest(post, "/reportExecutions",null);
                if(validateRequest(httpRes)) {
                    if (httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK
                            ||httpRes.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
                        response = getEntity(httpRes, ReportExecutionResponse.class);
                    }
                }
            } catch (Exception e) {
                log.error(e);
            } finally {
                releaseConnection(httpRes);
            }
        }
        return response;
    }

    private HttpResponse syncRes = null;
    public InputStream getReportPDF(ReportExecutionResponse execution){
        InputStream result = null;
        if(execution!=null && execution.getExports()!=null && execution.getExports().size()==1) {
            try {
                //Buscamos el archivo
                HttpGet get = new HttpGet();
                get.setHeader(JasperFile.HDR_CONTENT_TYPE, execution.getExports().get(0).getOutputResource().getContentType());
                get.setHeader("Accept", "application/json");
                StringBuilder url = new StringBuilder();
                url.append("/reportExecutions");
                url.append("/");
                url.append(execution.getRequestId());
                url.append("/exports/");
                url.append(execution.getExports().get(0).getId());
                url.append("/outputResource");
                syncRes = sendRequest(get, url.toString(), null);
                if (validateRequest(syncRes)) {
                    if (syncRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        result = syncRes.getEntity().getContent();
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        return result;
    }

    public void closeExecution(ReportExecutionResponse execution){
        if(execution!=null && execution.getExports()!=null && execution.getExports().size()==1) {
            try {
                //Buscamos el archivo
                HttpPut put = new HttpPut();
                put.setHeader(JasperFile.HDR_CONTENT_TYPE, "application/json");
                put.setHeader("Accept", "application/json");
                put.setEntity(new StringEntity("{ \"value\": \"cancelled\" }"));
                StringBuilder url = new StringBuilder();
                url.append("/reportExecutions");
                url.append("/");
                url.append(execution.getRequestId());
                url.append("/status/");
                syncRes = sendRequest(put, url.toString(), null);
                releaseConnection(syncRes);
            } catch (Exception e) {
                log.error(e);
            }
        }else{
            releaseConnection(syncRes);
        }
        logOut();

    }


    private String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    private InputStream stringToStream(final String str) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(str.getBytes("UTF-8"));
    }

}
