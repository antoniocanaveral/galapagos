package com.bmlaurus.rule;

import java.util.Date;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.util.DateUtil;

import org.json.JSONObject;

/**
 * Created by xsilva on 20/6/16.
 */
public class MarriedBeforeJune11Validator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla, RuleData ruleData) {
    	 boolean auspicianteFallecido = false; //llamar al servicio para validar si el auspiciante ha fallecido
         Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "2015-06-12");//aqui se debe llamar al servicio web para que devuelva la fecha de matrimonio 
     	 Date fechaDiezAnos = DateUtil.sumarAnos(fechaMatrimonio, DateUtil.ANOS);
     	 Date fechaActual = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "2025-06-01");// borrar solo pruebas
     	// Date fechaActual = new Date(); //Habilitar cuando se tenga el servicio  
        	
        	if(fechaMatrimonio.before(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))){
        		return "true";
        	}else{
        		if((fechaActual.after(fechaDiezAnos)) || (fechaActual.equals(fechaDiezAnos))){
        			return "true";
        	 	}else{
        	 		if(auspicianteFallecido){
        	 		   return "true";
        	 		}else{
        	 		 return "false,"+regla.getString("CRVAL_SUGERENCIA");
        	 		}
        	 	}
        		
    		}
       
    }
}
