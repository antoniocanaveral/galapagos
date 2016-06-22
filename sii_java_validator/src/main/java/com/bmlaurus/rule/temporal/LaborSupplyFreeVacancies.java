package com.bmlaurus.rule.temporal;

import org.json.JSONObject;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;

/**
 * Created by xsilva on 21/6/16.
 */
public class LaborSupplyFreeVacancies implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla) {
    	return "true";
    }

}
