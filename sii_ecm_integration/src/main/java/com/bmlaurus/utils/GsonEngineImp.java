package com.bmlaurus.utils;

import com.bmlaurus.alfresco.entity.serializer.AlfNodeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by acanaveral on 28/4/16.
 */
public class GsonEngineImp implements GsonEngine{

    public final static String GSON_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private Gson gson;
    private Map<String, Object> typeAdapters;

    public GsonEngineImp() {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat(GSON_DATE_TIME_FORMAT);
        //typeAdapters = new HashMap<String, Object>();
        //typeAdapters.put("com.bmlaurus.alfresco.entity.AlfNode", new AlfNodeSerializer());
        if (typeAdapters != null) {
            for (Map.Entry<String, Object> entry : typeAdapters.entrySet()) {
                try {
                    Class<?> interceptedClass = Class.forName(entry.getKey());
                    if (entry.getValue() instanceof JsonDeserializer
                            || entry.getValue() instanceof JsonSerializer) {
                        gsonBuilder.registerTypeAdapter(interceptedClass,
                                entry.getValue());
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        gson = gsonBuilder.create();
    }

    public Gson getGson() {
        return gson;
    }

    public <T> Object fromJsonWithReader(String json, Class t) {
        String evaluatedString = json.trim();
        if(evaluatedString.endsWith(",  }"))
            evaluatedString = evaluatedString.replace(",  }","}");
        JsonReader reader = new JsonReader(new StringReader(evaluatedString));
        reader.setLenient(true);
        return getGson().fromJson(reader,t);
    }
}
