/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.messaging.xml;

/**
 *
 * @author Richard Osmar Leon Ingaruca 
 * jaxb whitout anottations
 * http://stackoverflow.com/questions/10243679/when-does-jaxb-unmarshaller-unmarshal-returns-a-jaxbelementmyshemaobject-or-a
 * String from OutputStream
 * http://stackoverflow.com/questions/216894/get-an-outputstream-into-a-string
 */
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

public class XmlParserUtil {


    public static void parseBeanToXmlFileByJAXB(String path, Object bean, Class clase) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(clase);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Object> rootElement = new JAXBElement<Object>(new QName(clase.getSimpleName()), clase, bean);
        marshaller.marshal(rootElement, new FileOutputStream(path));
    }

    public static String parseBeanToXmlStringByJAXB(Object bean, Class clase) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(clase);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        JAXBElement<Object> rootElement = new JAXBElement<Object>(new QName(clase.getSimpleName()), clase, bean);

        OutputStream output = new OutputStream() {

            private StringBuilder string = new StringBuilder();

            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            //Netbeans IDE automatically overrides this toString()
            public String toString() {
                return this.string.toString();
            }
        };


        marshaller.marshal(rootElement, output);

        return output.toString();

    }

    public static Object parseXmlFileToBeanByJAXB(String path, Class clase) throws Exception {


        JAXBContext context = JAXBContext.newInstance(clase);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBElement elm = unmarshaller.unmarshal(new StreamSource(new File(path)), clase);

        return elm.getValue();

    }
    
    public static Object parseXmlStringToBeanByJAXB(String xml, Class clase) throws Exception {


        JAXBContext context = JAXBContext.newInstance(clase);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        if(is==null){
            return null;
        }
        
        JAXBElement elm = unmarshaller.unmarshal(new StreamSource(is), clase);

        return elm.getValue();

    }                
}
