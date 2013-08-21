/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.listener.menu.contextual;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author RM-RCMJ
 */
public class RightClickContexMenuListener extends JPopupMenu implements MouseListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RightClickContexMenuListener() {
    }

    public RightClickContexMenuListener(JMenuItem[] menus) {
        this.menus = menus;
        for (JMenuItem item : this.menus) {
            add(item);
        }
    }

    public void iniItemsMenu(JMenuItem[] menus) {
        for (JMenuItem item : menus) {
            add(item);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
        } // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {
            //insertaComponenteASession((JComponent) e.getSource());
            this.show(e.getComponent(), e.getX(), e.getY());
        }
    }



    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }

    public JMenuItem[] menus;

    /*public JMenuItem getItem1() {
        return item1;
    }

    public void setItem1(JMenuItem item1) {
        this.item1 = item1;
    }

    public JMenuItem getItem2() {
        return item2;
    }

    public void setItem2(JMenuItem item2) {
        this.item2 = item2;
    }

    public JMenuItem getItem3() {
        return item3;
    }

    public void setItem3(JMenuItem item3) {
        this.item3 = item3;
    }
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
     */
}
