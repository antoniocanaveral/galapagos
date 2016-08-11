package com.bmlaurus.attachment;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiIdentificable;
import com.bmlaurus.alfresco.integration.SiiRespaldoDocument;
import com.bmlaurus.alfresco.utils.GlobalsConfig;

import javax.activation.DataHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by acanaveral on 13/7/16.
 */
public class ResolucionAttachment extends ReportToAttachment {

    private String reportName;

    public ResolucionAttachment(String recordId, String tableName, String filter) {
        super(recordId, tableName, filter);
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String attachReport() throws SQLException {

        reportParams = new HashMap<>();
        reportParams.put("CRRST_CODIGO",recordId);

        Properties globals = GlobalsConfig.getConfig();
        if(globals!=null) {
            fileName = globals.getProperty("alfpath.resolucion.fileName");
            DataHandler stream = getReportExecutation("resoluciones",reportName);
            if(stream!=null){
                dh = stream;
                document = new SiiRespaldoDocument(tableName+"-"+recordId);//userData.getCedula());
                document.addAspect(new SiiIdentificable(tableName,recordId));
                document.setFileName(fileName+".pdf");
                Connection tmpCon = ManagerConnection.getConnection();
                document.setPath(SiiDataLoader.repoResolver(tmpCon,tableName,recordId,globals.getProperty("alfpath.resolucion.path")));
                tmpCon.close();
                if(uploadAttachment())
                    return "true";
            }
        }

        return null;
    }
}
