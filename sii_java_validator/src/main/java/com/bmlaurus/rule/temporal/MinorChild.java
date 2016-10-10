package com.bmlaurus.rule.temporal;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.bmlaurus.util.DateUtil;
import org.json.JSONObject;

import java.util.Date;
/**
 * Created by xsilva on 21/6/16.
 */
public class MinorChild implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {

        String error = regla.getString("CRVAL_SUGERENCIA");
        Date fechaNacimientoHijo =null;
        Date fechaTemp=null;
        
        try{
	        fechaNacimientoHijo = DateUtil.formatDate(DateUtil.F_ddMMyyyy, ruleData.getCRPER_FECHA_NACIMIENTO());
	        fechaTemp = DateUtil.sumarAnos(fechaNacimientoHijo, 18);
        }catch(NullPointerException ec){
            try {
                fechaNacimientoHijo = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, ruleData.getCRPER_FECHA_NACIMIENTO());
                fechaTemp = DateUtil.sumarAnos(fechaNacimientoHijo, 18);
            }catch (Exception e){
                return "true";
            }
        }    
        
        Date fechaActual = new Date();

        if(fechaActual.before(fechaTemp) || fechaActual.equals(fechaTemp)){
        	 return "true";
        }
        
        return "false,"+error;
    }
        
    }
