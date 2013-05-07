/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.paint.axis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.linet.api.swing.paint.PaintComponentUtil;

/**
 *
 * @author info4
 */
public class AxisPaintComponent implements MouseListener, MouseMotionListener,KeyListener {

//    public PintaEjesComponenteListener(ComponenteIcefaces componente) {
//        this.componente = componente;
//        this.componente.getComponent().addMouseListener(this);        // listens for own mouse and
//        this.componente.getComponent().addMouseMotionListener(this);  // mouse-motion events
//    }
    public AxisPaintComponent(JComponent componente) {
        this.componente = componente;
        this.componente.addMouseListener(this);        // listens for own mouse and
        this.componente.addMouseMotionListener(this);  // mouse-motion events
        this.componente.addKeyListener(this);  // mouse-motion events
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }

    public void mouseDragged(MouseEvent event) {

        Point p_ini = componente.getLocation();
        
        Graphics g = componente.getParent().getGraphics();
        //iteramos los vertices
        Graphics2D g2d = (Graphics2D) g;

        PaintComponentUtil.drawDashedAxis(g2d, p_ini.x,p_ini.y);

        //componente.getParent().validate();
        componente.getParent().repaint();

    }

    public void mouseMoved(MouseEvent e) {
        Point p_ini = componente.getLocation();

        Graphics g = componente.getParent().getGraphics();
        //iteramos los vertices
        Graphics2D g2d = (Graphics2D) g;

        PaintComponentUtil.drawDashedAxis(g2d, p_ini.x,p_ini.y);

        //componente.getParent().validate();
        componente.getParent().repaint();
    }
    

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
    public JComponent componente;
    
}
