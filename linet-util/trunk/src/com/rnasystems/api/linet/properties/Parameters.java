/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.rnasystems.api.linet.util.archivos.ArchivoUtil;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class Parameters {
    
    public static Properties properties = null;
    private static String path = null;
    
    public static Properties getInstance() {
        try {

            properties = new Properties();
            if(path==null){
                path = getDefaultPropertiesPath();
            }
            FileInputStream inputStream = new FileInputStream(new File(path));
            properties.load(inputStream);
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }    
    
    private static String getDefaultPropertiesPath(){
        return ArchivoUtil.getPathDirectorioEjecucion() + File.separator + "cfg.properties";
    }
    
    public static void initializePath(String myPath){
        path = myPath;
    }    
    
    public static String getProperty(String property) {

        if (properties == null) {
            properties = getInstance();
        }

        return properties.getProperty(property);
    }    
}
