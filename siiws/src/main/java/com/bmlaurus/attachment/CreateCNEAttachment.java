package com.bmlaurus.attachment;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiIdentificable;
import com.bmlaurus.alfresco.integration.SiiPersonalesDocument;
import com.bmlaurus.virtual.VirtualCache;
import com.bmlaurus.ws.dinardap.CNE;

import javax.activation.DataHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by acanaveral on 17/7/16.
 */
public class CreateCNEAttachment extends ReportToAttachment {

    private CNE userData;


    public CreateCNEAttachment(CNE userData, String recordId) {
        super(recordId,"Cgg_res_persona",null);
        this.userData = userData;
        this.recordId = recordId;
    }

    @Override
    public String attachReport() throws SQLException {
        reportParams = new HashMap<>();
        reportParams.put("CEDULA_DATOS",userData.toString());

        Properties globals = VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_GLOBALS);
        if(globals!=null) {
            fileName = globals.getProperty("alfpath.cert_votacion.fileName");
            DataHandler stream = getReportExecutation("generated","rptDinardapCNE");
            if(stream!=null){
                dh = stream;
                document = new SiiPersonalesDocument(userData.getCedula());
                document.addAspect(new SiiIdentificable(tableName,recordId));
                document.setFileName(fileName+".pdf");
                Connection tmpCon = ManagerConnection.getConnection();
                document.setPath(SiiDataLoader.repoResolver(tmpCon,tableName,recordId,globals.getProperty("alfpath.cert_votacion.path")));
                tmpCon.close();
                if(uploadAttachment())
                    return "true";
            }
        }

        return null;
    }
}
