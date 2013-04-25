/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.linet.util.file.FileUtil;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class PropertiesReady {
    
    public static Properties properties = null;
    private static String path = null;
    
    public static Properties getInstance() throws Exception {
        try {

            properties = new Properties();
            if(path==null){
                path = getDefaultPropertiesPath();
            }
            FileInputStream inputStream = new FileInputStream(new File(path));
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException ex) {
            throw new Exception("Error al leer achivo de propiedades:["+path+"]",ex);
        }
        return properties;
    }    
    
    private static String getDefaultPropertiesPath(){
        return FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "cfg.properties";
    }
    
    public static void initializePath(String myPath){
        path = myPath;
    }    
    
    public static String getProperty(String property) throws Exception {

        if (properties == null) {
            properties = getInstance();
        }
        
        String value = properties.getProperty(property);
        if(value==null){
            throw new Exception("Error al leer key de achivo de propiedades:["+path+"] key["+property+"]");
        }
        return value;
    }    
}
