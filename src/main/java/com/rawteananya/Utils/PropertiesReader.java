package com.rawteananya.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // Read the data.properties and give to anyone who wants with key.
    //


    public static  String readKey(String keys){

        Properties p;
        String user_directory = System.getProperty("user.dir");
        String filepath = user_directory + "/src/main/resources/Data.Properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);

            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return p.getProperty(keys);
    }
}
