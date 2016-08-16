package com.bmlaurus.rule;



import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisteredIdentificationBeneficiary implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {

        String error = regla.getString("CRVAL_SUGERENCIA");
        Cgg_res_persona beneficiario = new Cgg_res_persona();
        String identificacion = null;

        if(ruleData.getCRDID_CODIGO()==null || ruleData.getCRDID_CODIGO().trim().equals("")) {
            try {
                Connection con = null;
                con = ManagerConnection.getConnection();
                con.setAutoCommit(false);

                beneficiario.setCRPER_CODIGO(ruleData.getCGGCRPER_CODIGO());
                beneficiario = new com.besixplus.sii.db.Cgg_res_persona(beneficiario).select(con);
                identificacion = beneficiario.getCRDID_CODIGO();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            identificacion = ruleData.getCRDID_CODIGO();
        }

            if (identificacion.equals("1") ){

                RegistroCivil registroCivil = new RegistroCivil(ruleData.getCRPER_NUM_DOC_IDENTIFIC());//cedula del beneficiario
                if (registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)) {
                    if (registroCivil.getResultMap() != null)
                        error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
                    else
                        return "true," + RegistroCivil.SERVICE_ERROR;
                } else {
                    if (registroCivil.getCedula() != null && !registroCivil.getCedula().trim().isEmpty()) {
                        return "true";
                    }
                }
            }else {
                return "true";
            }
          
           return "false,"+error;
        
    }

}
