package com.bmlaurus.rule;

import org.json.JSONObject;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;

public class VoteCNEBeneficiary implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
    	return "true";
    }

}
