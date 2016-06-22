package com.bmlaurus.rule;

import java.util.Date;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.util.DateUtil;

import org.json.JSONObject;

/**
 * Created by xsilva on 20/6/16.
 */
public class Before10YearsSponsorDiedValidator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla) {
         boolean auspicianteFallecido = true; //llamar al servicio para validar si el auspiciante ha fallecido
		 
	     Date fechaMatrimonio = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "2016-06-05");//aqui se debe llamar al servicio web para que devuelva la fecha de matrimonio
	 	 Date fechaDiezAnos = DateUtil.sumarAnos(fechaMatrimonio, DateUtil.ANOS);
	 	 Date fechaActual = new Date(); 
	     
	 	if((fechaActual.before(fechaDiezAnos))
	 	        && auspicianteFallecido){
	 	  	 return "true";
	 	}else{
	 		 return "false,"+regla.getString("CRVAL_SUGERENCIA");
	 	}
    }
}
