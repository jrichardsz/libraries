/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author RLC-RM
 */
public class JtableMenuContextual implements MouseListener {

    public void insertaFuncionalidad(JTable jTable) {
        this.jTable = jTable;
        this.jTable.addMouseListener(this);
    }

    public void insertaMenuItems(String[] items){
        popup = new JPopupMenu(); //creamos el menu saliente
        for(String item:items){
            popup.add(new JMenuItem(item)); //agregamos elemento
        }
    }

    private void showPopup(MouseEvent e) {
      
        popup.show(e.getComponent(), e.getX(), e.getY());
      
    }

    public void mouseClicked(MouseEvent e) {
        // Left mouse click
        if (SwingUtilities.isLeftMouseButton(e)) {
            // Do something
        } // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {
            // get the coordinates of the mouse click
            Point p = e.getPoint();

            // get the row index that contains that coordinate
            int rowNumber = jTable.rowAtPoint(p);

            // Get the ListSelectionModel of the JTable
            ListSelectionModel model = jTable.getSelectionModel();

            // set the selected interval of rows. Using the "rowNumber"
            // variable for the beginning and end selects only that one row.
            model.setSelectionInterval(rowNumber, rowNumber);
            showPopup(e);
        }

    }

    public void mousePressed(MouseEvent e) {
     // showPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
      //showPopup(e);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    private JTable jTable;
    private JPopupMenu popup;
}
