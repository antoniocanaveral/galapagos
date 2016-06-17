package com.bmlaurus.rule;

import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import org.json.JSONObject;

/**
 * Created by acanaveral on 15/6/16.
 */
public class Before10YearsSponsorDiedValidator implements RuleClass {

    @Override
    public String executeRule(Cgg_regla_validacion_metadatos metadata, JSONObject regla) {
        return "true";
    }
}
