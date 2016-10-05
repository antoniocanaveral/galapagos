package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.util.DateUtil;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by xsilva on 20/6/16.
 */
public class MarriedBeforeJune11Validator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
        //Cgg_res_persona auspiciante = new Cgg_res_persona();
        String error = regla.getString("CRVAL_SUGERENCIA");
        
        /*try {
	        Connection con = null;
	        con = ManagerConnection.getConnection();	
	    	con.setAutoCommit(false);
			
	    	auspiciante.setCRPER_CODIGO(ruleData.getCRPER_CODIGO());
	    	auspiciante = new com.besixplus.sii.db.Cgg_res_persona(auspiciante).select(con);
	    	
			con.close();		    		
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		if(ruleData.getCRPER_FECHA_MATRIMONIO()!=null){
			try {
				Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_ddMMyyyy, ruleData.getCRPER_FECHA_MATRIMONIO());
				if (fechaMatrimonio.before(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))) {
					return "true";
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}else{
			RegistroCivil registroCivil = new RegistroCivil(ruleData.getCRPER_NUM_DOC_IDENTIFIC());
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
				Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_ddMMyyyy, registroCivil.getFechaMatrimonio());
				if (fechaMatrimonio.before(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))) {
					return "true";
				}
			}
		}

        /*RegistroCivil registroCivil = new RegistroCivil(auspiciante.getCRPER_NUM_DOC_IDENTIFIC());//cedula del auspiciante
        if(registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_ERROR)){
            if(registroCivil.getResultMap()!=null)
                error = (String) registroCivil.getResultMap().get(RegistroCivil.KEY_MENSAJE);
            else
                return "true,"+RegistroCivil.SERVICE_ERROR;
        }else{
        
        	if(registroCivil.getCedulaConyuge()==null || registroCivil.getCedulaConyuge().trim().isEmpty() 
            		|| registroCivil.getFechaMatrimonio()==null || registroCivil.getFechaMatrimonio().trim().isEmpty()){
       	    	return "false,"+regla.getString("CRVAL_SUGERENCIA");
            }
            
       	    boolean auspicianteFallecido = false;
            Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_ddMMyyyy, registroCivil.getFechaMatrimonio()); 
     	    Date fechaDiezAnos = DateUtil.sumarAnos(fechaMatrimonio, DateUtil.ANOS);
     	    Date fechaActual = new Date();   
     	    
     	    
            if(registroCivil.getFechaDefuncion()!=null && !registroCivil.getFechaDefuncion().trim().isEmpty()){
            	auspicianteFallecido = true;
            }
            	
            if(registroCivil.getCedulaConyuge().trim().equals(ruleData.getCRPER_NUM_DOC_IDENTIFIC())){//cedula del beneficiario
            	if(fechaMatrimonio.before(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))){
            		return "true";
               	}else{
               		if((fechaActual.after(fechaDiezAnos)) || (fechaActual.equals(fechaDiezAnos))){
               			return "true";
               	 	}else{
               	 		if(auspicianteFallecido){
               	 		   return "true";
               	 		}
               	 	}
               		
           		}
            }
        }*/
        
        return "false,"+error;
    }
}
