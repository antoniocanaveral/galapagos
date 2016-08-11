package com.bmlaurus.attachment;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiIdentificable;
import com.bmlaurus.alfresco.integration.SiiPersonalesDocument;
import com.bmlaurus.alfresco.utils.GlobalsConfig;
import com.bmlaurus.ws.dinardap.RegistroCivil;

import javax.activation.DataHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by acanaveral on 8/7/16.
 */

//Permite crear documentos obteniendo la informacion de la Dinardap
public class CreateRCAttachment extends ReportToAttachment {

    private RegistroCivil userData;


    public CreateRCAttachment(RegistroCivil userData, String recordId) {
        super(recordId,"Cgg_res_persona",null);
        this.userData = userData;
        this.recordId = recordId;
    }


    @Override
    public String attachReport() throws SQLException {
        //Llamar al reporte pasandole como parámetro lo que necesitamos
        //Construir el dh y aspectos previo la carga a alfresco
        //Subir al repositorio
        reportParams = new HashMap<>();
        reportParams.put("CEDULA_DATOS",userData.toString());

        Properties globals = GlobalsConfig.getConfig();
        if(globals!=null) {
            fileName = globals.getProperty("alfpath.identificacion.fileName");
            DataHandler stream = getReportExecutation("generated","rptDinardapCedula");
            if(stream!=null){
                dh = stream;
                document = new SiiPersonalesDocument(userData.getCedula());
                document.addAspect(new SiiIdentificable(tableName,recordId));
                document.setFileName(fileName+".pdf");
                Connection tmpCon = ManagerConnection.getConnection();
                document.setPath(SiiDataLoader.repoResolver(tmpCon,tableName,recordId,globals.getProperty("alfpath.identificacion.path")));
                tmpCon.close();
                if(uploadAttachment())
                    return "true";
            }
        }
        /*ESTO SOLO FUNCIONA SI SON PARAMETROS PEQUEÑOS NO JSON
        String url = buildReportUrl("generated","rptDinardapCedula");
        if(url!=null){
            document = new SiiPersonalesDocument(userData.getCedula());
            document.addAspect(new SiiIdentificable(tableName,recordId));
            Properties globals = Env.getExternalProperties("alfresco/globals.properties");
            if(globals!=null) {
                document.setFileName(globals.getProperty("personales.cedula.fileName"));
                Connection tmpCon = ManagerConnection.getConnection();
                document.setPath(SiiDataLoader.repoResolver(tmpCon,tableName,recordId,globals.getProperty("personales.cedula.path")));
                tmpCon.close();
            }
            try {
                URL urlJasper = new URL(url);
                InputStream stream = urlJasper.openStream();
                dh = new DataHandler(stream,"rptDinardapCedula.pdf");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(uploadAttachment())
                return "true";
        }*/
        return null;
    }
}
