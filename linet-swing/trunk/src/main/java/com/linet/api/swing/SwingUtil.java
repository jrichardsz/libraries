/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author ext_synps03
 */
public class SwingUtil {

    public static void centrarJDialog(JDialog jDialog) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - jDialog.getWidth()) / 2;
        int y = (screenSize.height - jDialog.getHeight()) / 2;
        jDialog.setLocation(x, y);
    }
    
    public static void centrarJFrame(JFrame  jFrame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - jFrame.getWidth()) / 2;
        int y = (screenSize.height - jFrame.getHeight()) / 2;
        jFrame.setLocation(x, y);
    }    

    public static String getNameNodoAtIndex(int ind, JTree jtree) {

        TreePath parentPath = jtree.getSelectionPath();
        //System.out.println("parentPath:" + parentPath);
        int nivel = 0;
        if (parentPath != null) {

            nivel = parentPath.getPathCount();
        }

        return "" + parentPath.getPathComponent(ind);
    }

    public static String getNameNodoPadreAnterior(JTree tree) {
        TreePath parentPath = tree.getSelectionPath();
        return "" + parentPath.getParentPath().getLastPathComponent();
    }

    public static DefaultMutableTreeNode buscarNodeByNombre(JTree jtree,String nodeStr) {
        DefaultMutableTreeNode node = null;
        TreeNode root = (TreeNode)jtree.getModel().getRoot();
        Enumeration e = root.children();
        while (e.hasMoreElements()) {
            node = (DefaultMutableTreeNode) e.nextElement();
            if ((node.getUserObject().toString()).contains(nodeStr)) {
                return node;
            }
        }
        return null;
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
