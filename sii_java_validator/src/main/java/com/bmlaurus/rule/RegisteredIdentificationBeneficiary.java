package com.bmlaurus.rule;



import org.json.JSONObject;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.ws.dinardap.RegistroCivil;

public class RegisteredIdentificationBeneficiary implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
    	
    	   String error = regla.getString("CRVAL_SUGERENCIA");
         	
    	   RegistroCivil registroCivil = new RegistroCivil(ruleData.getCRPER_NUM_DOC_IDENTIFIC());//cedula del auspiciante
           registroCivil.callServiceAsObject();
          
      	    if(registroCivil.getCedula()==null || registroCivil.getCedula().trim().isEmpty()){
      	    	return "false,"+error;
            }
      	          
           return "true";
        
    }
}
