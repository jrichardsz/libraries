/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.api.linet.util.swing;

import java.awt.Toolkit;

/**
 *
 * @author RM-RCMJ
 */
public class DinamicScreenUtil {

    public static int WIDTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static int WIDTH_PANEL_CORE = DinamicScreenUtil.WIDTH_SCREEN/7;
    public static int HEIGHT_PANEL_CORE = DinamicScreenUtil.HEIGHT_SCREEN/7;

    public static int HEIGHT_MENU_BAR = 35;
    public static int HEIGHT_BARRA_TITUTLO = 35;

    //Panel principal
    public static int X_PANEL_PRINCIPAL = 0;
    public static int Y_PANEL_PRINCIPAL = 0;
    public static int WIDHT_PANEL_PRINCIPAL = DinamicScreenUtil.WIDTH_PANEL_CORE*7;
    public static int HEIGHT_PANEL_PRINCIPAL = DinamicScreenUtil.HEIGHT_PANEL_CORE*7-HEIGHT_MENU_BAR-HEIGHT_BARRA_TITUTLO;

    //Panel Nuevo Proyecto
    public static int MARGEN_PANEL_NUEVO_PROYECTO = 4;
    public static int WIDHT_PANEL_NUEVO_PROYECTO = DinamicScreenUtil.WIDTH_SCREEN-DinamicScreenUtil.MARGEN_PANEL_NUEVO_PROYECTO;
    public static int HEIGHT_PANEL_NUEVO_PROYECTO = DinamicScreenUtil.HEIGHT_PANEL_PRINCIPAL-DinamicScreenUtil.MARGEN_PANEL_NUEVO_PROYECTO;

    //Panel disenio Panel Dragged
    public static int X_PANEL_DRAGGED = 10;
    public static int Y_PANEL_DRAGGED = 30;
    public static int WIDHT_PANEL_DRAGGED  = DinamicScreenUtil.WIDTH_PANEL_CORE*5;
    public static int HEIGHT_PANEL_DRAGGED  = DinamicScreenUtil.HEIGHT_PANEL_CORE*5;


    //Panel JTree Dinamico
    public static int X_PANEL_DINAMICO = 10;
    public static int Y_PANEL_DINAMICO = 30;
    public static int WIDHT_PANEL_DINAMICO  = DinamicScreenUtil.WIDTH_PANEL_CORE*5+DinamicScreenUtil.WIDTH_PANEL_CORE/2;
    public static int HEIGHT_PANEL_DINAMICO  = DinamicScreenUtil.HEIGHT_PANEL_CORE*5;



    //Panel disenio Panel Paleta
    public static int X_PANEL_PALETA= DinamicScreenUtil.WIDTH_PANEL_CORE*5+30;
    public static int Y_PANEL_PALETA = 30;
    public static int WIDHT_PANEL_PALETA  = DinamicScreenUtil.WIDTH_PANEL_CORE*2-50;
    public static int HEIGHT_PANEL_PALETA  = DinamicScreenUtil.HEIGHT_PANEL_CORE*5;

    //Panel disenio JLabel coordenadas del cursos
    public static int X_LABEL_COORDENADAS = 10;
    public static int Y_LABEL_COORDENADAS = 10;
    public static int WIDHT_LABEL_COORDENADAS = 150;
    public static int HEIGHT_LABEL_COORDENADAS = 15;

    //Panel disenio JButton Limpiar
    public static int WIDHT_BUTTON_LIMPIAR = 80;
    public static int HEIGHT_BUTTON_LIMPIAR = 20;
    public static int X_BUTTON_LIMPIAR = DinamicScreenUtil.WIDTH_PANEL_CORE*5-DinamicScreenUtil.WIDHT_BUTTON_LIMPIAR;
    public static int Y_BUTTON_LIMPIAR = 8;

    //Panel Codigo JButton Actualizar
    public static int WIDHT_BUTTON_ACTUALIZAR = 80;
    public static int HEIGHT_BUTTON_ACTUALIZAR = 20;
    public static int X_BUTTON_ACTUALIZAR = 10;
    public static int Y_BUTTON_ACTUALIZAR = 10;

    //Panel disenio JtextAreaCodigo
    public static int X_TEXT_CODIGO= 10;
    public static int Y_TEXT_CODIGO = 35;
    public static int WIDHT_TEXT_CODIGO  = DinamicScreenUtil.WIDTH_PANEL_CORE*6;
    public static int HEIGHT_TEXT_CODIGO  = DinamicScreenUtil.HEIGHT_PANEL_CORE*4;


    //Panel disenio JtextAreaCodigo
    public static int NUM_INI_ROWS_PANELGRID= 3;
    public static int NUM_INI_COLS_PANELGRID= 3;


    public static void limpiar(){
        
    }
}
