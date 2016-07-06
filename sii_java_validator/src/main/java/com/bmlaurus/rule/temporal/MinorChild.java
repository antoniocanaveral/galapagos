package com.bmlaurus.rule.temporal;

import java.util.Date;

import com.bmlaurus.rule.RuleData;
import org.json.JSONObject;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.util.DateUtil;
/**
 * Created by xsilva on 21/6/16.
 */
public class MinorChild implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla, RuleData ruleData) {

    	
        Date fechaNacimientoHijo = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "1998-06-20");//aqui se debe llamar al servicio web para que devuelva la fecha de nacimieno del hijo
        Date fechaTemp = DateUtil.sumarAnos(fechaNacimientoHijo, 18);
        Date fechaActual = new Date();

          if(fechaActual.after(fechaTemp) || fechaActual.equals(fechaTemp)){
	   		 return "true";
	   	}else{
	   		 return "false,"+regla.getString("CRVAL_SUGERENCIA");
	   	}
    }
        
    }
