package com.bmlaurus.phaserule;

import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.bmlaurus.rule.RulePhase;

import java.sql.Connection;

/**
 * Created by acanaveral on 7/7/16.
 */
public class GenerarResolucion implements RulePhase {

    private final String FUNCTION_NAME = "F_GENERAR_RESIDENCIA";

    private Connection connection;

    @Override
    public void setConnection(Connection conn) {
        connection = conn;
    }

    @Override
    public String executeRule(Cgg_res_seguimiento objSeguimiento, Cgg_res_tramite tramite, String inUserName) {
        String tmpMsg = new com.besixplus.sii.db.Cgg_res_seguimiento().ejecutarFuncionSeguimiento(connection,FUNCTION_NAME,objSeguimiento.getCRSEG_CODIGO(),inUserName);

        if(tmpMsg.equals("true")){//Se generó la residencia. Ahora hacemos la resolucion
            //Supongo que para cada tipo de residencia habrá un reporte distinto. Lo ponemos como parametro.
        }

        return tmpMsg;
    }
}
