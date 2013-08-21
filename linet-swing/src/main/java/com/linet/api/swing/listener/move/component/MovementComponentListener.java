/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.listener.move.component;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.linet.api.swing.component.dragdrop.DragDropComponent;

/**
 *
 * @author info4
 */
public class MovementComponentListener implements MouseListener, MouseMotionListener, KeyListener {


    public MovementComponentListener(DragDropComponent componente) {
        this.component = componente;
        this.component.getComponent().addMouseListener(this);        // listens for own mouse and
        this.component.getComponent().addMouseMotionListener(this);  // mouse-motion events        
        this.component.getComponent().addKeyListener(this);  // mouse-motion events        
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent event) {
        x_ini = event.getX();
        y_ini = event.getY();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent event) {
        Point p = component.getComponent().getLocation();
        x_fin = (event.getX() - x_ini + (int) p.getX());
        y_fin = (event.getY() - y_ini + (int) p.getY());
        //componente.getComponent().setLocation(x_fin,y_fin); 
        component.setCoordenadas(x_fin, y_fin);
        //componente.getComponent().setToolTipText("Posicion : ["+p.getX()+" ; "+p.getY()+"]    "+"Dimension : ["+componente.getComponent().getSize().width+" ; "+componente.getComponent().getSize().height+"]\t");
    }

    public void mouseMoved(MouseEvent e) {
        Point p = component.getComponent().getLocation();
        component.getComponent().setToolTipText("Posicion : [" + p.getX() + " ; " + p.getY() + "]    " + "Dimension : [" + component.getComponent().getSize().width + " ; " + component.getComponent().getSize().height + "]\t");
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent ke) {
        Point p = ((JComponent)ke.getSource()).getLocation();
        
        x_ini = (int)p.getX();
        y_ini = (int)p.getY();
        
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {           
        	component.setCoordenadas(x_ini, y_ini + 1);            
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
        	component.setCoordenadas(x_ini, y_ini - 1);            
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        	component.setCoordenadas(x_ini - 1, y_ini);            
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        	component.setCoordenadas(x_ini + 1, y_ini);
        }       
    }

    public void keyReleased(KeyEvent e) {
    }

    public int getX_fin() {
        return x_fin;
    }

    public void setX_fin(int x_fin) {
        this.x_fin = x_fin;
    }

    public int getY_fin() {
        return y_fin;
    }

    public void setY_fin(int y_fin) {
        this.y_fin = y_fin;
    }
    
    private DragDropComponent component;
    private int x_ini = 0;
    private int y_ini = 0;
    private int x_fin = 0;
    private int y_fin = 0;
}
