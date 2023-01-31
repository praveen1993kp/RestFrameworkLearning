package com.api.utils;

import java.io.*;
import java.util.Properties;

public class ConfigLoader {
    /**
     * Loads Configuration file, As this will be reading static file - reusing the same object to read files (Singelton pattern)
     */

    private static final String DEFAULT_PROPERTIES = "config";


    private static ConfigLoader configLoader;
    public static   Properties prop;

    private ConfigLoader() {
        String env =System.getenv("ENV");
        if(env==null)
            prop = ReadProp.getConfigPropertyFile(DEFAULT_PROPERTIES);
        else prop=ReadProp.getConfigPropertyFile(env);
    }


        public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

}
