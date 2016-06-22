package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.bmlaurus.rule.RuleClass;
import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public class FreeUnionValidator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla) {
        boolean unionDeHecho = true;//aqui se debe llamar al servicio web para que devuelva la union de hecho
    	
    	if(unionDeHecho){
    		 return "true";
    	}else{
    		 return "false,"+regla.getString("CRVAL_SUGERENCIA");
    	}
    }
}
