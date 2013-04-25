package com.linet.api.swing.filechooser;

import java.io.*;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserUtil {

    static JFileChooser accesoArchivo;
    static FileNameExtensionFilter filter;

    public static String getRutaGuardarArchivo(String titulo, String formato) {
        String rutaGuardar = null;
        accesoArchivo = new JFileChooser();
        filter = new FileNameExtensionFilter("Archivos " + formato, formato, formato);
        accesoArchivo.setFileFilter(filter);
        accesoArchivo.setSelectedFile(new File("archivo_" + (new Date()).getTime() + "." + formato));
        int indicador = 0;
        try {
            accesoArchivo.setDialogTitle(titulo);
            indicador = accesoArchivo.showSaveDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaGuardar = accesoArchivo.getSelectedFile().getAbsolutePath();
            } else {
                rutaGuardar = null;
            }
        } catch (Exception e) {
        }
        return rutaGuardar;
    }

    public static String getRutaGuardarArchivo(String titulo, String nombreArchivo, String formato) {
        String rutaGuardar = null;
        accesoArchivo = new JFileChooser();
        filter = new FileNameExtensionFilter("Archivos " + formato, formato, formato);
        accesoArchivo.setFileFilter(filter);
        accesoArchivo.setSelectedFile(new File(nombreArchivo + "_" + (new Date()).getTime() + "." + formato));
        int indicador = 0;
        try {
            accesoArchivo.setDialogTitle(titulo);
            indicador = accesoArchivo.showSaveDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaGuardar = accesoArchivo.getSelectedFile().getAbsolutePath();
            } else {
                rutaGuardar = null;
            }
        } catch (Exception e) {
        }
        return rutaGuardar;
    }

    public static String getRutaAbrirArchivo(String titulo, String formato) {
        String rutaAbrir = null;
        accesoArchivo = new JFileChooser();
        filter = new FileNameExtensionFilter("Archivos " + formato, formato, formato);
        accesoArchivo.setFileFilter(filter);

        int indicador = 0;
        try {
            accesoArchivo.setDialogTitle(titulo);
            indicador = accesoArchivo.showOpenDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaAbrir = accesoArchivo.getSelectedFile().getAbsolutePath();
            } else {
                rutaAbrir = null;
            }

        } catch (Exception e) {
        }
        return rutaAbrir;
    }

    public static String getRutaAbrirArchivo(String defaultFolder, String titulo, String formato) {
        String rutaAbrir = null;
        accesoArchivo = new JFileChooser(defaultFolder);
        filter = new FileNameExtensionFilter("Archivos " + formato, formato, formato);
        accesoArchivo.setFileFilter(filter);

        int indicador = 0;
        try {
            accesoArchivo.setDialogTitle(titulo);
            indicador = accesoArchivo.showOpenDialog(null);
            if (indicador == JFileChooser.APPROVE_OPTION) {
                rutaAbrir = accesoArchivo.getSelectedFile().getAbsolutePath();
            } else {
                rutaAbrir = null;
            }

        } catch (Exception e) {
        }
        return rutaAbrir;
    }
}
