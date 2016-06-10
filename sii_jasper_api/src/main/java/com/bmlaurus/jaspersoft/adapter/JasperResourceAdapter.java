package com.bmlaurus.jaspersoft.adapter;

import com.bmlaurus.jaspersoft.model.JasperReport;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by acanaveral on 7/6/16.
 */
public class JasperResourceAdapter implements JsonSerializer<JasperReport.Resource> {

    @Override
    public JsonElement serialize(JasperReport.Resource src, Type typeOfSrc, JsonSerializationContext context) {
        if(src!=null){
            JsonObject element = new JsonObject();
            //element.addProperty("name",src.getName());
        }
        return JsonNull.INSTANCE;
    }
}
