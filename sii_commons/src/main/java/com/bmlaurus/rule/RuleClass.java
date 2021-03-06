package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public interface RuleClass {

    /**
     * @return String false,Message | false | true,Message | true
     * */
    String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla, RuleData ruleData);
}
