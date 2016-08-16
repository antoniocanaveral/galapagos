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
 * Created by acanaveral on 4/8/16.
 */
public class HijoDelRepresentante implements RuleClass{

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
                              JSONObject regla, RuleData ruleData) {

        String error = regla.getString("CRVAL_SUGERENCIA");

        String cedulaBeneficiario = ruleData.getCRPER_NUM_DOC_IDENTIFIC();
        String cedulaRepresentante = null;

        Cgg_res_persona representante = new Cgg_res_persona();
        try {
            Connection con = null;
            con = ManagerConnection.getConnection();
            con.setAutoCommit(false);
            representante.setCRPER_CODIGO(ruleData.getREP_CRPER_CODIGO());
            representante = new com.besixplus.sii.db.Cgg_res_persona(representante).select(con);
            cedulaRepresentante = representante.getCRPER_NUM_DOC_IDENTIFIC();
            representante = null;
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(cedulaRepresentante!=null && cedulaBeneficiario!=null){
            RegistroCivil registroCivil = new RegistroCivil(cedulaBeneficiario);
            if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
                error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
            }else{
                if(registroCivil.getCedulaMadre()!=null && registroCivil.getCedulaMadre().equals(cedulaRepresentante)){
                    return "true";
                }else if(registroCivil.getCedulaPadre()!=null && registroCivil.getCedulaPadre().equals(cedulaRepresentante)){
                    return "true";
                }
            }
        }

        return "false,"+error;
    }
}
