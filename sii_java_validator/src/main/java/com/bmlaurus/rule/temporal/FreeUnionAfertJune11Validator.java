package com.bmlaurus.rule.temporal;


import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.bmlaurus.util.Constantes;
import com.bmlaurus.util.DateUtil;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by xsilva 21/6/16.
 */
public class FreeUnionAfertJune11Validator implements RuleClass {

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
            if(registroCivil.getResultMap()!=null) {
				error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
				//if(error.equals("07:PAQUETE DE INFORMACION INCORRECTO")){
				return "true";
				//}
			}
            else
                return "true,"+RegistroCivil.SERVICE_ERROR;
        }else{
        	if(registroCivil.getEstadoCivil()==null || registroCivil.getEstadoCivil().trim().isEmpty() 
              		|| registroCivil.getCedulaConyuge()==null || registroCivil.getCedulaConyuge().trim().isEmpty()
              		|| registroCivil.getFechaMatrimonio()==null || registroCivil.getFechaMatrimonio().trim().isEmpty()){
            	 return "true,"+Constantes.MENSAJE_DATOS_NULOS;
        	    }
        	 
             Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_ddMMyyyy, registroCivil.getFechaMatrimonio()); 
             
             if(registroCivil.getCedulaConyuge().trim().equals(ruleData.getCRPER_NUM_DOC_IDENTIFIC())){//cedula del beneficiario
             	if(registroCivil.getEstadoCivil().equalsIgnoreCase(Constantes.UNION_DE_HECHO)){
             		if(fechaMatrimonio.after(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))){
             			return "true";
             		}
             		
               	}
             }	
        }
         
         return "false,"+error;
        
    }
}
