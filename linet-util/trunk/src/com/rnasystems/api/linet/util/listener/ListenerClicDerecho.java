/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.api.linet.util.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author RM-RCMJ
 */
public class ListenerClicDerecho implements MouseListener{

    public ListenerClicDerecho(JPopupMenu menuPropiedades) {
        this.menuPropiedades = menuPropiedades;
    }




    public void mouseClicked(MouseEvent e) {
        System.out.println("cliccccccccc");
        if (SwingUtilities.isLeftMouseButton(e)) {

        } // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {
            insertaComponenteASession((JComponent) e.getSource());
            menuPropiedades.show(e.getComponent(), e.getX(), e.getY());
        }

    }

    public void insertaComponenteASession(JComponent component){
//        AppUtil.sessionMap.put("Componente_focus", component);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    private JPopupMenu menuPropiedades;

}
