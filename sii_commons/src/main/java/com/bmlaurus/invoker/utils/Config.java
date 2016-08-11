package com.bmlaurus.invoker.utils;

import com.besixplus.sii.util.Env;

import java.util.Properties;

/**
 * Created by acanaveral on 28/4/16.
 */
public class Config {

    private static Properties config;

    public static Properties getConfig() {
        if (config == null) {
            config = Env.getExternalProperties("invoker/config.properties");
        }

        return config;
    }
}
