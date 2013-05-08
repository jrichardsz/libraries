/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ext_synps03
 */
public class SwingUtil {

    public static void centerJDialog(JDialog jDialog) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - jDialog.getWidth()) / 2;
        int y = (screenSize.height - jDialog.getHeight()) / 2;
        jDialog.setLocation(x, y);
    }

    public static void showDialogWhitImage(URL pathuRL){
        
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel();
        jLabel.setIcon(new javax.swing.ImageIcon(pathuRL)); // NOI18N
        panel.add(jLabel);
        JOptionPane.showMessageDialog ( null, panel ); 
        jLabel = null;
        panel = null;
    }
}
