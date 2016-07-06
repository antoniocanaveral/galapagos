package com.bmlaurus.rule;


import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.ws.dinardap.RegistroCivil;

public class RegisteredIdentification implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
    	
    	String error = regla.getString("CRVAL_SUGERENCIA");
        Cgg_res_persona auspiciante = new Cgg_res_persona();
        try {
	        Connection con = null;
	        con = ManagerConnection.getConnection();	
	    	con.setAutoCommit(false);
			
	    	auspiciante.setCRPER_CODIGO(ruleData.getCRPER_CODIGO());
	    	auspiciante = new com.besixplus.sii.db.Cgg_res_persona(auspiciante).select(con);
	    	
			con.close();		    		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
         	
    	   RegistroCivil registroCivil = new RegistroCivil(auspiciante.getCRPER_NUM_DOC_IDENTIFIC());//cedula del auspiciante
           registroCivil.callServiceAsObject();
          
      	    if(registroCivil.getCedula()==null || registroCivil.getCedula().trim().isEmpty()){
      	    	return "false,"+error;
            }
      	          
           return "true";
        
    }
}
