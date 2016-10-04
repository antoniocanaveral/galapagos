package com.bmlaurus.rule;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 4/8/16.
 */
public class HijoDelAuspiciante  implements RuleClass{

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
                              JSONObject regla, RuleData ruleData) {

        String error = regla.getString("CRVAL_SUGERENCIA");

        String cedulaBeneficiario = ruleData.getCRPER_NUM_DOC_IDENTIFIC();
        String cedulaAuspiciante = null;

        Cgg_res_persona auspiciante = new Cgg_res_persona();
        try {
            Connection con = null;
            con = ManagerConnection.getConnection();
            con.setAutoCommit(false);
            auspiciante.setCRPER_CODIGO(ruleData.getCRPER_CODIGO());
            auspiciante = new com.besixplus.sii.db.Cgg_res_persona(auspiciante).select(con);
            cedulaAuspiciante = auspiciante.getCRPER_NUM_DOC_IDENTIFIC();
            auspiciante = null;
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(cedulaAuspiciante!=null && cedulaBeneficiario!=null){
            RegistroCivil registroCivil = new RegistroCivil(cedulaBeneficiario);
            if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
                error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
                System.err.println(error);
                //Damos por válido cuando no puede conectarse al RC.
                return "true";
            }else{
                if(registroCivil.getCedulaMadre()!=null && registroCivil.getCedulaMadre().equals(cedulaAuspiciante)){
                    return "true";
                }else if(registroCivil.getCedulaPadre()!=null && registroCivil.getCedulaPadre().equals(cedulaAuspiciante)){
                    return "true";
                }
            }
        }

        return "false,"+error;
    }
}
