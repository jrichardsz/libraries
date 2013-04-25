/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.log;

import java.io.InputStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log {

    private static String FQCN = Log.class.getName();
    public static boolean isReady = false;
    public static Logger logger = Logger.getLogger(Log.class);    
    
//    static {
//
//        String readMyLog4j = System.getProperty("mylog4j.external");
//
//        if (readMyLog4j != null && readMyLog4j.equals("true")) {
//            try {
//                new Log4jSetting().readExternalLog4jProperties();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//    }

    public static void resetConfiguration(String path_properties) {
        try {
            new Log4jSetting().readExternalLog4jProperties(path_properties);
            isReady = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void resetConfiguration(InputStream inputStream) {
        try {
            new Log4jSetting().readExternalLog4jProperties(inputStream);
            isReady = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    


    /**
     * <b>Debug:</b> <br> El nivel DEBUG se utiliza para escribir mensajes de
     * depuración.
     *
     * @param message Mensaje a ser escrito en el log.
     */
    public static void debug(Object message) {
        //if (debug.equals(Log.SI)) {
        logger.log(FQCN, Level.DEBUG, message, null);
        //}
    }

    /**
     * <b>Debug:</b> <br> El nivel DEBUG se utiliza para escribir mensajes de
     * depuración.
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void debug(Object message, Throwable exception) {
        //if (debug.equals(Log.SI)) {
        logger.log(FQCN, Level.DEBUG, message, exception);
        //}
    }

    /**
     * <b>Info:</b> <br> El nivel INFO está asociado con eventos significativos
     * en el ciclo de vida normal de la aplicación
     *
     * @param message Mensaje a ser escrito en el log.
     */
    public static void info(Object message) {
        //if (info.equals(Log.SI)) {
        logger.log(FQCN, Level.INFO, message, null);
        //}
    }

    /**
     * <b>Info:</b> <br> El nivel INFO está asociado con eventos significativos
     * en el ciclo de vida normal de la aplicación
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void info(Object message, Throwable exception) {
        //if (info.equals(Log.SI)) {
        logger.log(FQCN, Level.INFO, message, exception);
        // }
    }

    /**
     * <b>Warn:</b> <br> El nivel WARN se utiliza para mensajes de alerta sobre
     * eventos que se desea mantener constancia, pero que no afectan el
     * funcionamiento del programa.
     *
     * @param message Mensaje a ser escrito en el log.
     */
    public static void warn(Object message) {
        // if (warn.equals(Log.SI)) {
        logger.log(FQCN, Level.WARN, message, null);
        //}
    }

    /**
     * <b>Warn:</b> <br> El nivel WARN se utiliza para mensajes de alerta sobre
     * eventos que se desea mantener constancia, pero que no afectan el
     * funcionamiento del programa.
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void warn(Object message, Throwable exception) {
        //if (warn.equals(Log.SI)) {
        logger.log(FQCN, Level.INFO, message, exception);
        //}
    }

    /**
     * <b>Error:</b> <br> El nivel ERROR se utiliza generalmente para las
     * excepciones. Las condiciones de error no necesariamente causan que la
     * aplicación deje de funcionar.
     *
     * @param message Mensaje a ser escrito en el log.
     */
    public static void error(Object message) {
        //if (error.equals(Log.SI)) {
        logger.log(FQCN, Level.ERROR, message, null);
        //}
    }

    /**
     * <b>Error:</b> <br> El nivel ERROR se utiliza generalmente para las
     * excepciones. Las condiciones de error no necesariamente causan que la
     * aplicación deje de funcionar.
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void error(Object message, Throwable exception) {
        ///if (error.equals(Log.SI)) {
        logger.log(FQCN, Level.ERROR, message, exception);
        //}
    }

    /**
     * <b>Fatal:</b> <br> El nivel FINAL se utiliza para mensajes críticos del
     * sistema, generalmente luego de guardar el mensaje el programa abortará.
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void fatal(Object message) {
        logger.log(FQCN, Level.FATAL, message, null);
    }

    /**
     * <b>Fatal:</b> <br> El nivel FINAL se utiliza para mensajes críticos del
     * sistema, generalmente luego de guardar el mensaje el programa abortará.
     *
     * @param message Mensaje a ser escrito en el log.
     * @param exception Excepcion a ser escrita en el log.
     */
    public static void fatal(Object message, Throwable exception) {
        logger.log(FQCN, Level.INFO, message, exception);
    }
}
