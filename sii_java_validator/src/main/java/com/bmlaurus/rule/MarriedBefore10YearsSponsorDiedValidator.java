package com.bmlaurus.rule;

import java.util.Date;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.util.DateUtil;

import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public class MarriedBefore10YearsSponsorDiedValidator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
        
    	 boolean auspicianteFallecido = true; //llamar al servicio para validar si el auspiciante ha fallecido
		 
	     Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "2015-06-12");//aqui se debe llamar al servicio web para que devuelva la fecha de matrimonio
	 	 Date fechaDiezAnos = DateUtil.sumarAnos(fechaMatrimonio, DateUtil.ANOS);
	 	 Date fechaActual = new Date(); 
	     
	 	if((fechaMatrimonio.after(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO)))
	 			&& (fechaActual.before(fechaDiezAnos))
	 	        && auspicianteFallecido){
	 		return "true";
	 	}else{
	 		return "false,"+regla.getString("CRVAL_SUGERENCIA");
	 	}
	 	
    }
}
