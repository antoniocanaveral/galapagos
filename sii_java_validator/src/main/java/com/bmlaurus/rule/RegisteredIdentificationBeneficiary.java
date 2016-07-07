package com.bmlaurus.rule;



import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

public class RegisteredIdentificationBeneficiary implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
    	
    	   String error = regla.getString("CRVAL_SUGERENCIA");
         	
    	   RegistroCivil registroCivil = new RegistroCivil(ruleData.getCRPER_NUM_DOC_IDENTIFIC());//cedula del beneficiario
           if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
               if(registroCivil.getResultMap()!=null)
                   error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
               else
                   return "true,"+RegistroCivil.SERVICE_ERROR;
           }else{
        	   if(registroCivil.getCedula()!=null && !registroCivil.getCedula().trim().isEmpty()){
         	    	return "true";
               }   
           }
          
           return "false,"+error;
        
    }
}
