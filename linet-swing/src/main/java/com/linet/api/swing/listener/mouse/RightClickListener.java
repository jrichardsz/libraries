/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.linet.api.swing.listener.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author RM-RCMJ
 */
public class RightClickListener implements MouseListener{

    public RightClickListener(JPopupMenu menuItems) {
        this.menuItems = menuItems;
    }




    public void mouseClicked(MouseEvent e) {
        
        if (SwingUtilities.isLeftMouseButton(e)) {

        } // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {
            insertaComponenteASession((JComponent) e.getSource());
            menuItems.show(e.getComponent(), e.getX(), e.getY());
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

    private JPopupMenu menuItems;

}
