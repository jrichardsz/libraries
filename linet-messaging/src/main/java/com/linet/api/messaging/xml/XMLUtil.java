/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.messaging.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class XMLUtil {
     public static void writeBeanToXml(String path, Object bean) {
        XMLEncoder encoder = null;
        try {
            // Serialize object into XML
            encoder = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream(path)));
            encoder.writeObject(bean);
            encoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (encoder != null) {
                encoder.close();
            }
        }
    }

    public static Object readBeanFromXml(String path) throws Exception {
        FileInputStream fis = null;
        Object aplicacion = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(path);
            bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            aplicacion = (Object) xmlDecoder.readObject();


        } catch (FileNotFoundException ex) {
            throw new Exception("File to read not found.",ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    throw new Exception("File to close FileInputStream after read.",ex);
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ex) {
                    throw new Exception("File to close BufferedInputStream after read.",ex);
                }
            }
        }


        return aplicacion;

    }
}
