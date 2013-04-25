/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import com.rnasystems.api.linet.util.archivos.ArchivoUtil;

/**
 *
 * @author ext_synps03
 */
public class Log4jSetting {

    public void changeLog4jProperties() throws Exception {

        Properties props = new Properties();
        try {
            InputStream configStream = getClass().getResourceAsStream("/log4j.properties");
            props.load(configStream);
            configStream.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        props.setProperty("log4j.appender.FILE.Directory", ArchivoUtil.getPathDirectorioEjecucion() + File.separator + "Logs");
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(props);

    }

    public void readExternalLog4jProperties() throws Exception {

        try {
            Properties props = new Properties();
            FileInputStream inputStream = new FileInputStream(new File(ArchivoUtil.getPathDirectorioEjecucion() + File.separator + "log4j.properties"));
            props.load(inputStream);
            inputStream.close();
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(props);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readExternalLog4jProperties(String path_properties) throws Exception {

        try {
            Properties props = new Properties();
            FileInputStream inputStream = new FileInputStream(new File(path_properties));
            props.load(inputStream);
            inputStream.close();
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(props);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readExternalLog4jProperties(InputStream inputStream) throws Exception {

        try {
            Properties props = new Properties();
            props.load(inputStream);
            inputStream.close();
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(props);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
