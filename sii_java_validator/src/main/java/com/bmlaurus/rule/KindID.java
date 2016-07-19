package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import org.json.JSONObject;

/**
 * Created by Gmabel on 21/6/16.
 */
public class KindID implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata,
			JSONObject regla, RuleData ruleData) {
    	
        String error = regla.getString("CRVAL_SUGERENCIA");;
        String kingID =ruleData.getCRDID_CODIGO();

        if (kingID!=null && (kingID.equals("1") || kingID.equals("2")) ){
            return "true";
        }

        return "false, "+error;
    }
        
}
