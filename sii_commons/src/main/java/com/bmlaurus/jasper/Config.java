package com.bmlaurus.jasper;

import com.besixplus.sii.util.Env;

import java.util.Properties;

/**
 * Created by acanaveral on 28/4/16.
 */
public class Config {

    private static Properties config;

    public static Properties getConfig() {
        if (config == null) {
            //PropertyConfigurator.configure(Env.getExternalProperties("loggin/log4j.properties"));
            config = Env.getExternalProperties("jasper/config.properties");
        }

        return config;
    }
}
