package com.bmlaurus.virtual;

import com.besixplus.sii.util.Env;

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

    public static final String PROP_MAILING_FORMAT = "mailing/format.properties";



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


    public static void resetPropertie(String propertyFile){
        if(cachedProperties != null){
            cachedProperties.replace(propertyFile,null);
        }
    }

    public static void resetCache(){
        cachedProperties = null;
    }
}
