package com.bmlaurus.attachment;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.util.Env;
import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiIdentificable;
import com.bmlaurus.alfresco.integration.SiiRespaldoDocument;

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
        //reportParams.put("CEDULA_DATOS",userData.toString());

        Properties globals = Env.getExternalProperties("alfresco/globals.properties");
        if(globals!=null) {
            fileName = globals.getProperty("alfpath.resolucion.fileName");
            DataHandler stream = getReportExecutation("generated",reportName);
            if(stream!=null){
                dh = stream;
                document = new SiiRespaldoDocument("");//userData.getCedula());
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