package com.bmlaurus.virtual;

import com.besixplus.sii.util.Env;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by acanaveral on 10/8/16.
 */

public class VirtualCache {

    public static final String PROP_ALFRESCO_CONF = "alfresco/config.properties";
    public static final String PROP_ALFRESCO_GLOBALS = "alfresco/globals.properties";

    public static final String PROP_JASPER_CONF = "jasper/config.properties";

    public static final String PROP_INVOKER_CONF = "invoker/config.properties";
    public static final String PROP_INTEGRATION_CONF = "integration/config.properties";


    public static final String PROP_MAILING_FORMAT = "mailing/format.properties";
    public static final String PROP_MAILING_CONF = "mailing/config.properties";

    public static final String PROP_DINARDAP_CONF = "dinardap/config.properties";

    public static final String PROP_CRON_CONF = "cron/config.properties";

    public static final String PROP_RULES_RESOLUCION = "rules/resolucion.properties";

    public static final String PROP_DATABASE_CONF = "database/database.properties";

    private static Map<String,Properties> cachedProperties;

    public static Properties getConfig(String propertyFile) {
        Properties config = null;
        if(cachedProperties == null) //Iniciamos el mapa la primera vez
            cachedProperties = new HashMap<>();
        config = cachedProperties.get(propertyFile);
        if(config==null) {
            config = Env.getExternalProperties(propertyFile);
            cachedProperties.put(propertyFile,config);
        }
        return config;
    }


    public static void resetProperty(String propertyFile){
        if(cachedProperties != null){
            cachedProperties.replace(propertyFile,null);
        }
    }

    public static void resetCache(){
        cachedProperties = null;
    }

    public static String toJSON(){
        String json = null;
        if(cachedProperties!=null)
            json = new Gson().toJson(cachedProperties);
        else
            json = "Cache is NULL";
        return json;
    }

    public static String toPrettyJSON(){
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String json = null;
        if(cachedProperties!=null) {
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(new Gson().toJson(cachedProperties));
            json = gson.toJson(je);
            json = json.replace("\n","<br/>").replace("    ","&nbsp;&nbsp;&nbsp;&nbsp;");
        }else
            json = "Cache is NULL";
        gson = null;
        return json;
    }
}
