package com.linet.api.swing.jtree;

/*
 * This code is based on an example provided by Richard Stanford, 
 * a tutorial reader.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeDinamico extends JPanel {

    protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    protected JTree tree;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();

    public JTreeDinamico() {
        rootNode = new DefaultMutableTreeNode("Proyectos");
        treeModel = new DefaultTreeModel(rootNode);

        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        setLayout(new GridLayout(5, 5));
        add(scrollPane);

    }

    public JTreeDinamico(String nombreNodoDefecto) {
        rootNode = new DefaultMutableTreeNode(nombreNodoDefecto);
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        setLayout(null);
        add(tree);
    }

    /** Remove all nodes except the root node. */
    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    /** Remove the currently selected node. */
    public void removeCurrentNode() {
        TreePath currentSelection = tree.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }
        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /** Add child to the currently selected node. */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();
        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child,
            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        // Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.expandPath(new TreePath(parent.getPath()));
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public JTree getTree() {
        return tree;
    }

    public void setSizeTree(int width, int height) {
        setSize(width, height);
        tree.setSize(width, height);
    }
    /*Vector<String> v = new Vector<String>();
    v.add("a");
    v.add("b");
    v.add("c");
    JTree tree = new JTree(v);
    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

    int startRow = 0;
    String prefix = "b";
    TreePath path = tree.getNextMatch(prefix, startRow, Position.Bias.Forward);
    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();

    model.removeNodeFromParent(node);*/
}
