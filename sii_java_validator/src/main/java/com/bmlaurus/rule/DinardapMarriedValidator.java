package com.bmlaurus.rule;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by acanaveral on 15/6/16.
 */
public class DinardapMarriedValidator implements RuleClass {

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

		if(ruleData.getCRPER_FECHA_MATRIMONIO()!=null && ruleData.getCRPER_CONYUGE()!=null){
			if(ruleData.getCRPER_CONYUGE().equals(auspiciante.getCRPER_NUM_DOC_IDENTIFIC())){
				return "true";
			}else{
				error = "El Cónyuge del Beneficiario no coincide con el Auspiciante";
			}
		}else{
			error = "Fecha de Matrimonio y Cédula del Cónyuge deben estar llenos";
		}
         	
        /*RegistroCivil registroCivil = new RegistroCivil(auspiciante.getCRPER_NUM_DOC_IDENTIFIC());//cedula del auspiciante
        if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
	          if(registroCivil.getResultMap()!=null)
	              error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
	          else
	              return "true,"+RegistroCivil.SERVICE_ERROR;
        }else{

        	  if(registroCivil.getCedulaConyuge()==null || registroCivil.getCedulaConyuge().trim().isEmpty()){ 
            	  return "true,"+Constantes.MENSAJE_DATOS_NULOS;
       	      }
            
              if(registroCivil.getCedulaConyuge()!=null && registroCivil.getCedulaConyuge().trim().equals(ruleData.getCRPER_NUM_DOC_IDENTIFIC())){//cedula del beneficiario
             	  return "true";
              }
        }*/
        
        return "false,"+error;
        
    }
}
