package com.bmlaurus.phaserule;

import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.util.Env;
import com.bmlaurus.rule.RulePhase;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by acanaveral on 7/7/16.
 */
public class GenerarResolucion extends RulePhase {

    private final String FUNCTION_NAME = "F_GENERAR_RESIDENCIA";


    public GenerarResolucion(Connection connection) {
        super(connection);
    }

    @Override
    public String executeRule(Cgg_res_seguimiento objSeguimiento, Cgg_res_tramite tramite, String inUserName) {
        String tmpMsg = new com.besixplus.sii.db.Cgg_res_seguimiento().ejecutarFuncionSeguimiento(connection,FUNCTION_NAME,objSeguimiento.getCRSEG_CODIGO(),inUserName);

        if(tmpMsg!=null && !tmpMsg.equalsIgnoreCase("false")){//Se generó la residencia. Ahora hacemos la resolucion
            //Supongo que para cada tipo de residencia habrá un reporte distinto. Lo ponemos como parametro.
            Properties props = Env.getExternalProperties("rules/resolucion.properties");
            if(props!=null){
                String reportName = props.get("DEFAULT").toString();
                if(props.get(tramite.getCRTST_CODIGO())!=null)
                    reportName = (String) props.get(tramite.getCRTST_CODIGO());

                //Obtenemos el Numero de Resolucion Secuencial y la fecha. Lo ponemos en la residencia



                //Ya tenemos el reporte que hay que hacer. Lo invocamos y guardamos en BG.
                //El reporte generado lo ponemos en Alfresco* Tal vez requiera llamar a un WS o un Servlet.
            }
        }
        //FIXME: Controlar el return de la funcion.
        return tmpMsg;
    }
}
