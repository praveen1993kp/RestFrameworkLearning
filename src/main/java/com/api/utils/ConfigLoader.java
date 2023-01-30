package com.api.utils;

import java.io.*;
import java.util.Properties;

public class ConfigLoader {
    /**
     * Loads Configuration file, As this will be reading static file - reusing the same object to read files (Singelton pattern)
     */

    private static final String CONFIG_PROPERTIES = ".properties";
    private static final String DEFAULT_PROPERTIES = "config" + CONFIG_PROPERTIES;
    private static  final String RESOURCE_PATH = System.getProperty("user.dir")+"/src/main/resources/";


    private static ConfigLoader configLoader;
    public static   Properties prop;

    private ConfigLoader() {
        String env =System.getenv("ENV");
        if(env==null)
            prop = getConfigPropertyFile(DEFAULT_PROPERTIES);
        else prop=getConfigPropertyFile(env+CONFIG_PROPERTIES);
    }



    public static Properties getConfigPropertyFile(String filePath) {
        Properties properties = null;
        FileReader reader = null;
        try {
            properties = new Properties();
            reader = new FileReader(RESOURCE_PATH+filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find the file specified "+filePath);
        }
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the Properties file: " + filePath);
        }
        return properties;
    }

        public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

}
