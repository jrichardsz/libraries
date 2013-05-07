/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.paint.axis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import com.linet.api.swing.paint.PaintComponentUtil;

/**
 *
 * @author info4
 */
public class AdvancedAxisPaintComponent extends AxisPaintComponent {

    public AdvancedAxisPaintComponent(JComponent componente) {
        super(componente);
        this.container = componente.getParent();
    }

    public void mouseDragged(MouseEvent event) {
        pintaEjes(event.getSource().hashCode());
    }

    public void mouseMoved(MouseEvent e) {
        pintaEjes(e.getSource().hashCode());
    }

    public void mouseClicked(MouseEvent e) {
        //System.out.println("mouseClicked");
    }

    public void mousePressed(MouseEvent event) {
        //System.out.println("mousePressed");
    }

    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouseReleased");
    }

    public void mouseEntered(MouseEvent e) {
        //System.out.println("mouseEntered");
    }

    public void mouseExited(MouseEvent e) {
        //System.out.println("mouseExited");
    }

    public String[] detectaOtrosComponentes(int hashcode) {
        //primero obentenemos los demas compoenetes dentro del container:

        Component[] components = container.getComponents();
        String[] ejes = {"", ""};
        Point p_ini = componente.getLocation();

        Point p_i = null;
        for (Component c : components) {

            //obtengo la coordenada de este componente
            if (c.hashCode() != hashcode) { // si este componente no es el que se esta moviendo
                p_i = c.getLocation();

                if (p_i.x == p_ini.x) {// si las coordenadas x son iguales
                    // consultamos en que lado del eje esta
                    if (p_i.y < p_ini.y) { // el componenente encontrado esta encima de nuestro compoenente
                        ejes[0] = "up";
                    } else {
                        ejes[0] = "down";
                    }
                }

                if (p_i.y == p_ini.y) {// si las coordenadas x son iguales
                    // consultamos en que lado del eje esta

                    if (p_i.x < p_ini.x) { // el componenente encontrado esta encima de nuestro compoenente

                        ejes[1] = "left";
                    } else {

                        ejes[1] = "right";
                    }
                }

            }
        }

        return ejes;
    }


    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            pintaEjes(ke.getSource().hashCode());
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            pintaEjes(ke.getSource().hashCode());
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            pintaEjes(ke.getSource().hashCode());
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            pintaEjes(ke.getSource().hashCode());
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void pintaEjes(int hashcode) {

        String[] ejes = detectaOtrosComponentes(hashcode);

        Point p_ini = componente.getLocation();

        Graphics g = componente.getParent().getGraphics();
        //iteramos los vertices
        Graphics2D g2d = (Graphics2D) g;

        //GraphicUtil.drawDashedEjes(g2d, p_ini.x, p_ini.y);
        Color c1 = Color.BLUE;
        Color c2 = Color.BLUE;

        Color c3 = Color.BLUE;
        Color c4 = Color.BLUE;

        if (ejes[0].equals("up")) {
            c3 = Color.RED;
            c4 = Color.BLUE;
        } else if (ejes[0].equals("down")) {
            c3 = Color.BLUE;
            c4 = Color.RED;
        } else {
            c3 = Color.BLUE;
            c4 = Color.BLUE;
        }

        if (ejes[1].equals("left")) {
            c1 = Color.RED;
            c2 = Color.BLUE;
        } else if (ejes[1].equals("right")) {
            c1 = Color.BLUE;
            c2 = Color.RED;
        } else {
            c1 = Color.BLUE;
            c2 = Color.BLUE;
        }

        PaintComponentUtil.drawDashedAxis(g2d, p_ini.x, p_ini.y, c1, c2, c3, c4);
        //componente.getParent().validate();
        componente.getParent().repaint();

    }
    
    
    
        private Container container;
}
