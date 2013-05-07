package com.linet.api.swing.filechooser;

import java.io.*;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserUtil {

    public static String getFilePathToSave(String title, String format) throws Exception {

        return getFilePathToSave(title,null,format);
    }

    public static String getFilePathToSave(String title, String nameToSave, String format) throws Exception {
        
    	JFileChooser jFileChooser;
    	FileNameExtensionFilter filter;
    	String rutaGuardar = null;
    	jFileChooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Files " + format, format, format);
        jFileChooser.setFileFilter(filter);
        jFileChooser.setSelectedFile(new File(((nameToSave!=null && !nameToSave.equals(""))? nameToSave : "file_" ) + "_" + (new Date()).getTime() + "." + format));
        int indicador = 0;
        try {
        	jFileChooser.setDialogTitle(title);
            indicador = jFileChooser.showSaveDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaGuardar = jFileChooser.getSelectedFile().getAbsolutePath();
            } else {
            	throw new Exception("The event was not yes nor ok.");
            }
        } catch (Exception e) {
        	throw new Exception("Error when try to get path of file to save it.",e);
        }
        return rutaGuardar;
    }

    public static String getFilePathToOpen(String title, String format) throws Exception {
        
        return getFilePathToOpen(title ,null, format);
    }

    public static String getFilePathToOpen(String title , String defaultFolder , String format) throws Exception {
        
    	JFileChooser jFileChooser;
    	FileNameExtensionFilter filter;
    	String rutaAbrir = null;
    	
    	if(defaultFolder!=null && !defaultFolder.equals("")){
    		jFileChooser = new JFileChooser(defaultFolder);
    	}else {
    		jFileChooser = new JFileChooser();
    	}
    	
    	
        filter = new FileNameExtensionFilter("Archivos " + format, format, format);
        jFileChooser.setFileFilter(filter);

        int indicador = 0;
        try {
        	jFileChooser.setDialogTitle(title);
            indicador = jFileChooser.showOpenDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaAbrir = jFileChooser.getSelectedFile().getAbsolutePath();
            } else {
            	throw new Exception("The event was not yes nor ok.");
            }

        } catch (Exception e) {
        	throw new Exception("Error when try to get path of file to open it.",e);
        }
        return rutaAbrir;
    }
}
