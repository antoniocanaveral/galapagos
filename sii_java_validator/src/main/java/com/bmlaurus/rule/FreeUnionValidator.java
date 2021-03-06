package com.bmlaurus.rule;

import java.sql.Connection;
import java.sql.SQLException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.util.Constantes;
import com.bmlaurus.ws.dinardap.RegistroCivil;

import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public class FreeUnionValidator implements RuleClass {
	
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
        if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
            if(registroCivil.getResultMap()!=null)
                error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
            else
                return "true,"+RegistroCivil.SERVICE_ERROR;
        }else{
        
        	if(registroCivil.getEstadoCivil()==null || registroCivil.getEstadoCivil().trim().isEmpty() 
             		|| registroCivil.getCedulaConyuge()==null || registroCivil.getCedulaConyuge().trim().isEmpty()){
            	 return "true,"+Constantes.MENSAJE_DATOS_NULOS;
       	    }
       	 
            if(registroCivil.getCedulaConyuge().trim().equals(ruleData.getCRPER_NUM_DOC_IDENTIFIC())){//cedula del beneficiario
            	if(registroCivil.getEstadoCivil().equalsIgnoreCase(Constantes.UNION_DE_HECHO)){
            		return "true";
               	}
            }
        }
        
  		 return "false,"+error;
    }
}
