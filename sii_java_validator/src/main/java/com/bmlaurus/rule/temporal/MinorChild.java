package com.bmlaurus.rule.temporal;

import java.util.Date;

import org.json.JSONObject;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.bmlaurus.util.DateUtil;
/**
 * Created by xsilva on 21/6/16.
 */
public class MinorChild implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
        String error = regla.getString("CRVAL_SUGERENCIA");
    
   	 
        Date fechaNacimientoHijo = DateUtil.formatDate(DateUtil.F_ddMMyyyy, ruleData.getCRPER_FECHA_NACIMIENTO());
        Date fechaTemp = DateUtil.sumarAnos(fechaNacimientoHijo, 18);
        System.out.println(fechaTemp);
        Date fechaActual = new Date();

        if(fechaActual.before(fechaTemp) || fechaActual.equals(fechaTemp)){
        	 return "true";
        }
        
        return "false,"+error;
    }
        
    }
