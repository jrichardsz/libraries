package com.linet.api.swing.jtree;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JTreeUtil {
	
	public static String getNameNodoAtIndex(int ind, JTree jtree) {

        TreePath parentPath = jtree.getSelectionPath();
        
        int level = 0;
        if (parentPath != null) {

        	level = parentPath.getPathCount();
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
        Enumeration<?> e = root.children();
        while (e.hasMoreElements()) {
            node = (DefaultMutableTreeNode) e.nextElement();
            if ((node.getUserObject().toString()).contains(nodeStr)) {
                return node;
            }
        }
        return null;
    }

}
