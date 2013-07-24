/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

/**
 *
 * @author RM-RCMJ
 */
public class PaintComponentUtil {

    public static boolean componentIsInContainer(JComponent container, JComponent component) {
        Point p = container.getLocation();
        Point xy = component.getLocation();
        Dimension d = container.getSize();
//        System.out.println("estaDentro??");
//        System.out.println("container:"+p);
//        System.out.println("componente:"+xy);
//        //System.out.println("(xy.x > p.x && xy.x < p.x + d.width) && (xy.y > p.y && xy.y < p.y + d.height):"+((xy.x > p.x && xy.x < p.x + d.width) && (xy.y > p.y && xy.y < p.y + d.height)));
//        System.out.println(""+xy.x+">"+p.x + " = " +(xy.x > p.x) );
//        System.out.println(""+xy.x+"<"+p.x +" + "+ d.width  + " = " +(xy.x < p.x + d.width) );
//        
//        System.out.println(""+xy.y+">"+p.y + " = " +(xy.y > p.y) );
//        System.out.println(""+xy.y+"<"+p.y +" + "+ d.height  + " = " +(xy.y < p.y + d.height) );
//        
//        
//        
        if ((xy.x > p.x && xy.x < p.x + d.width) && (xy.y > p.y && xy.y < p.y + d.height)) {
            return true;
        } else {
            return false;
        }
    }

    public static void drawLineDashed(Graphics2D g2d, int x1, int y1, int x2, int y2) {

        /*
        BasicStroke stroke = new BasicStroke(
        10f,                       // grosor: 10 píxels
        BasicStroke.CAP_BUTT,      // terminación: recta
        BasicStroke.JOIN_ROUND,    // unión: redondeada
        1f,                        // ángulo: 1 grado
        new float[] {10, 5, 5, 5}, // línea de 10, 5 blancos, línea de 5, 5 blancos
        2                          // fase
        );*/

        Line2D line2D = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        g2d.draw(line2D);
    }

    public static void drawLineDashed(Graphics2D g2d, int x1, int y1, int x2, int y2, Color c) {

        /*
        BasicStroke stroke = new BasicStroke(
        10f,                       // grosor: 10 píxels
        BasicStroke.CAP_BUTT,      // terminación: recta
        BasicStroke.JOIN_ROUND,    // unión: redondeada
        1f,                        // ángulo: 1 grado
        new float[] {10, 5, 5, 5}, // línea de 10, 5 blancos, línea de 5, 5 blancos
        2                          // fase
        );*/

        Line2D line2D = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        g2d.draw(line2D);
    }

    public static void drawAxis(Graphics2D g2d, int x_ini, int y_ini) {

        int longitud_eje = 300;
        //pintamos el eje -y
        g2d.drawLine(x_ini, y_ini, x_ini, y_ini - longitud_eje);
        //pintamos el eje y
        g2d.drawLine(x_ini, y_ini, x_ini, y_ini + longitud_eje);
        //pintamos el eje -x
        g2d.drawLine(x_ini - longitud_eje, y_ini, x_ini, y_ini);
        //pintamos el eje x
        g2d.drawLine(x_ini + longitud_eje, y_ini, x_ini, y_ini);

    }

    public static void drawDashedAxis(Graphics2D g2d, int x_ini, int y_ini) {

        int longitud_eje = 300;
        //pintamos el eje -y
        Line2D line2D_1 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini - longitud_eje);
        //pintamos el eje y
        Line2D line2D_2 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini + longitud_eje);
        //pintamos el eje -x
        Line2D line2D_3 = new Line2D.Double(x_ini - longitud_eje, y_ini, x_ini, y_ini);
        //pintamos el eje x
        Line2D line2D_4 = new Line2D.Double(x_ini + longitud_eje, y_ini, x_ini, y_ini);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        g2d.draw(line2D_1);
        g2d.draw(line2D_2);
        g2d.draw(line2D_3);
        g2d.draw(line2D_4);

    }
    
    public static void drawDashedAxis(Graphics2D g2d, int x_ini, int y_ini,Color c1x, Color c2x,Color c1y, Color c2y) {

        int longitud_eje = 300;
        //pintamos el eje -y
        Line2D line2D_1 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini - longitud_eje);
        //pintamos el eje y
        Line2D line2D_2 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini + longitud_eje);
        //pintamos el eje -x
        Line2D line2D_3 = new Line2D.Double(x_ini - longitud_eje, y_ini, x_ini, y_ini);
        //pintamos el eje x
        Line2D line2D_4 = new Line2D.Double(x_ini + longitud_eje, y_ini, x_ini, y_ini);
        
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        
        g2d.setColor(c1y);
        g2d.draw(line2D_1);
        g2d.setColor(c2y);
        g2d.draw(line2D_2);
        g2d.setColor(c1x);
        g2d.draw(line2D_3);
        g2d.setColor(c2x);
        g2d.draw(line2D_4);

    }    

    public static void drawDashedAxiX(Graphics2D g2d, int x_ini, int y_ini, Color c1, Color c2) {
        
        int longitud_eje = 300;
        //pintamos el eje -x
        Line2D line2D_3 = new Line2D.Double(x_ini - longitud_eje, y_ini, x_ini, y_ini);
        //pintamos el eje x
        Line2D line2D_4 = new Line2D.Double(x_ini + longitud_eje, y_ini, x_ini, y_ini);
        g2d.setColor(c1);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        g2d.draw(line2D_3);
        g2d.setColor(c2);
        g2d.draw(line2D_4);

    }

    public static void drawDashedAxiY(Graphics2D g2d, int x_ini, int y_ini, Color c1, Color c2) {

        int longitud_eje = 300;
        //pintamos el eje -y
        Line2D line2D_1 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini - longitud_eje);
        //pintamos el eje y
        Line2D line2D_2 = new Line2D.Double(x_ini, y_ini, x_ini, y_ini + longitud_eje);
        g2d.setColor(c1);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10, 5, 5, 5}, 0f));
        g2d.draw(line2D_1);
        g2d.setColor(c2);
        g2d.draw(line2D_2);

    }
}
