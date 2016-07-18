package com.bmlaurus.phaserule;

import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.Cgg_res_resol_tramite;
import com.besixplus.sii.objects.Cgg_res_resolucion;
import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.util.Env;
import com.bmlaurus.invoker.BackendInvoker;
import com.bmlaurus.rule.RulePhase;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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
        //PRIMERO LA RESOLUCION

        String tmpMsg = "false";
        try {
            //INSERT EN RESOLUCION - INSERT RES_TRAMITE
            Cgg_res_resolucion resolucion = new Cgg_res_resolucion();
            resolucion.setCRRES_CODIGO("KEYGEN");
            resolucion.setCRRES_TIPO(CGGEnumerators.TipoResolucion.Aprobacion.getValue());
            resolucion.setCRRES_ESTADO(true);
            resolucion.setCRRES_FECHA_EMISION(new Date());
            resolucion.setCRRES_ESTADO_RESOLUCION(CGGEnumerators.EstadoResolucion.Aprobada.getValue());
            resolucion.setCRRES_EXTRACTO_RESOLUCION("Tramite No. " + tramite.getCRTRA_NUMERO() + "\nResolucion Generada automáticamente por el sistema integral");
            resolucion.setCRRES_USUARIO_INSERT("sii");
            resolucion.setCRRES_USUARIO_UPDATE(inUserName);
            try {
                String inCrres_numero_resolucion = com.besixplus.sii.db.Cgg_res_resolucion.numeroResolucion(connection, tramite.getCISLA_CODIGO(), tramite.getCRTRA_CODIGO());
                if(inCrres_numero_resolucion!=null)
                    resolucion.setCRRES_NUMERO_RESOLUCION(inCrres_numero_resolucion);
            }catch (Exception e){
                e.printStackTrace();
            }
            String outResult = new com.besixplus.sii.db.Cgg_res_resolucion(resolucion).insert(connection);

            Cgg_res_resol_tramite resol_tramite = null;
            if(outResult.equals("true")) {
                resol_tramite = new Cgg_res_resol_tramite();
                resol_tramite.setCRRST_CODIGO("KEYGEN");
                resol_tramite.setCRRES_CODIGO(resolucion.getCRRES_CODIGO());
                resol_tramite.setCRTRA_CODIGO(tramite.getCRTRA_CODIGO());
                resol_tramite.setCRRST_ESTADO(true);
                resol_tramite.setCRRST_USUARIO_INSERT("sii");
                resol_tramite.setCRRST_USUARIO_UPDATE(inUserName);
                String outResolTra = new com.besixplus.sii.db.Cgg_res_resol_tramite(resol_tramite).insert(connection);
            }

            tmpMsg = new com.besixplus.sii.db.Cgg_res_seguimiento().ejecutarFuncionSeguimiento(connection,FUNCTION_NAME,objSeguimiento.getCRSEG_CODIGO(),inUserName);
            if(tmpMsg!=null && !tmpMsg.equalsIgnoreCase("false")) {//Se generó la residencia.

                Properties props = Env.getExternalProperties("rules/resolucion.properties");
                if(props!=null) {
                    String reportName = props.get("DEFAULT").toString();
                    if (props.get(tramite.getCRTST_CODIGO()) != null)
                        reportName = (String) props.get(tramite.getCRTST_CODIGO());
                    //Ya tenemos el reporte que hay que hacer. Lo invocamos y guardamos en BG.
                    //El reporte generado lo ponemos en Alfresco* Requiere llamar al Servlet de BackendInvoker.
                    if (resol_tramite != null && !resol_tramite.getCRRST_CODIGO().equals("KEYGEN")) {
                        final Map<String, String> param = new HashMap<>();
                        param.put("CRRST_CODIGO", resol_tramite.getCRRST_CODIGO());
                        param.put("CRRES_CODIGO", resolucion.getCRRES_CODIGO());
                        param.put("CRTRA_CODIGO", tramite.getCRTRA_CODIGO());
                        param.put("REPORT_NAME", reportName);
                        Thread t = new Thread() {
                            public void run() {
                                BackendInvoker backendInvoker = new BackendInvoker();
                                try {
                                    backendInvoker.invokeBackendServlet("ReportToAlfrescoSVR", "POST", new Gson().toJson(param));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        t.start();
                    }
                }

            }

        }catch (SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return tmpMsg;
    }
}
