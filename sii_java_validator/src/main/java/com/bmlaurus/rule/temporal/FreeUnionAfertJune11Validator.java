package com.bmlaurus.rule.temporal;


import java.util.Date;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.bmlaurus.util.DateUtil;

import org.json.JSONObject;

/**
 * Created by xsilva 21/6/16.
 */
public class FreeUnionAfertJune11Validator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla, RuleData ruleData) {

    	Date fechaUnionDeHecho = DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, "2015-06-12");//aqui se debe llamar al servicio web para que devuelva la fecha de matrimonio
    	
        if(fechaUnionDeHecho.after(DateUtil.formatDate(DateUtil.F_yyyy_MM_dd, DateUtil.FECHA_11JUNIO))){
	   		 return "true";
	   	}else{
	   		 return "false,"+regla.getString("CRVAL_SUGERENCIA");
	   	}
	   	
        
    }
}
