package com.api.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

    private static final String CONFIG_PROPERTIES = ".properties";
    private static  final String RESOURCE_PATH = System.getProperty("user.dir")+"/src/main/resources/";
    private static final String DEFAULT_PROPERTIES = "config";


    public static Properties getConfigPropertyFile(String fileName) {
        Properties properties = null;
        FileReader reader = null;
        String filePath = fileName+CONFIG_PROPERTIES;
        try {
            properties = new Properties();
            reader = new FileReader(RESOURCE_PATH+filePath);
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            try{
                System.out.println("Could not find "+fileName+" configuration , trying to load default properties");
                reader=new FileReader(RESOURCE_PATH+DEFAULT_PROPERTIES+CONFIG_PROPERTIES);
                properties.load(reader);
                reader.close();
                return properties;
            }catch (Exception e1) {
                throw new RuntimeException("Could not find the file specified " + filePath +" And Default config file");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the Properties file: " + filePath);
        }
        return properties;
    }

}
