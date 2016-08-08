package com.bmlaurus.rule.temporal;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral,mortiz on 8/8/16.
 */
public class PadreDelAuspiciante implements RuleClass{

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
            RegistroCivil registroCivil = new RegistroCivil(cedulaAuspiciante);
            if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
                error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
            }else{
                if(registroCivil.getCedulaMadre()!=null && registroCivil.getCedulaMadre().equals(cedulaBeneficiario)){
                    return "true";
                }else if(registroCivil.getCedulaPadre()!=null && registroCivil.getCedulaPadre().equals(cedulaBeneficiario)){
                    return "true";
                }
            }
        }

        return "false,"+error;
    }
}
