package com.bmlaurus.attachment;

import com.besixplus.sii.ws.JasperServerService;
import com.bmlaurus.alfresco.AlfrescoActions;
import com.bmlaurus.alfresco.integration.SiiAttachmentDocument;
import com.bmlaurus.alfresco.integration.SiiFileResult;
import com.bmlaurus.alfresco.utils.InputStreamDataSource;
import com.bmlaurus.jaspersoft.model.ReportExecutionResponse;
import com.bmlaurus.jaspersoft.services.ReportExecutionService;
import com.bmlaurus.virtual.VirtualCache;

import javax.activation.DataHandler;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by acanaveral on 9/7/16.
 */
public abstract class ReportToAttachment {

    /*Alfresco*/
    protected String fileName;
    protected String recordId;
    protected String tableName;
    protected String filter;
    protected DataHandler dh;
    protected SiiAttachmentDocument document;

    protected Map<String,String> reportParams;
    private final String BASE_REPORT_URL = "/flow.html?_flowId=viewReportFlow&standAlone=true";


    public ReportToAttachment(String recordId, String tableName, String filter) {
        this.recordId = recordId;
        this.tableName = tableName;
        this.filter = filter;
    }

    /**
     * AttachReport Es la funcion que hace el trabajo completo en todas las clases hijas.
     * */
    public abstract String attachReport() throws SQLException;

    protected boolean uploadAttachment(){
        boolean generated = false;
        //Subimos el reporte a Alfresco
        if(dh!=null && document!=null){
            SiiFileResult result = AlfrescoActions.createFile(dh, document);
            if(result!=null && result.getId()!=null)
                generated=true;
        }
        return generated;
    }


    protected DataHandler getReportExecutation(String reportFolder, String reportName){
        DataHandler handler = null;
        JasperServerService reportService = new JasperServerService();
        String valid = reportService.validateReport(reportFolder,reportName);
        if(valid.equals("{\"result\":true}")) {
            ReportExecutionService executionService = new ReportExecutionService();
            if(executionService.loginToServer()) {
                ReportExecutionResponse executionResponse = executionService.prepareReport(reportParams, reportFolder, reportName);
                if (executionResponse != null) {
                    InputStream resultStream = executionService.getReportPDF(executionResponse);
                    handler = new DataHandler(new InputStreamDataSource(resultStream, fileName + ".pdf"));
                    executionService.closeExecution(executionResponse);
                }
                executionService.logOut();
            }
        }
        return handler;
    }

    protected String buildReportUrl(String reportFolder, String reportName){
        StringBuilder url = new StringBuilder();
        JasperServerService reportService = new JasperServerService();
        String valid = reportService.validateReport(reportFolder,reportName);
        if(valid.equals("{\"result\":true}")) {
            Properties reportProps = VirtualCache.getConfig(VirtualCache.PROP_JASPER_CONF);
            if (reportProps != null) {
                url.append(reportProps.getProperty("SCHEME"));
                url.append("://");
                url.append(reportProps.getProperty("HOST"));
                url.append(":");
                url.append(reportProps.getProperty("PORT"));
                url.append(reportProps.getProperty("SERVER_HANDLE"));
                url.append(BASE_REPORT_URL);
                url.append("&j_username=");
                url.append(reportProps.getProperty("SII_CLI_UNAME"));
                url.append("&j_password=");
                url.append(reportProps.getProperty("SII_CLI_PWD"));
                url.append("&output=pdf");
                url.append("&reportUnit=");
                url.append(reportProps.getProperty("SII_REPORTS_PATH"));
                url.append("/");
                url.append(reportFolder);
                url.append("/");
                url.append(reportName);
                url.append("&ParentFolderUri=");
                url.append(reportFolder);

                if(reportParams!=null){
                    try {
                        for(Map.Entry entry: reportParams.entrySet()){
                            url.append("&");
                            url.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                            url.append("=");
                            url.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }
        }else
            return null;

        return url.toString();
    }



}
