/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.jtable;

import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ext_synps03
 */
public class JTableUtil {

    public static AbstractTableModel getDinamicModel(Vector<String> nombreColumnas) {
        JTableDynamicModel temp = new JTableDynamicModel(nombreColumnas);
        return temp;
    }

    public static void insertComponenteInColumn(JTable jTable, int col, JComponent jComponent) {
        TableColumn sportColumn = jTable.getColumnModel().getColumn(col);
        if (jComponent instanceof JComboBox) {
            sportColumn.setCellEditor(new DefaultCellEditor((JComboBox) jComponent));
        } else if (jComponent instanceof JCheckBox) {
            sportColumn.setCellEditor(new DefaultCellEditor((JCheckBox) jComponent));
        } else if (jComponent instanceof JTextField) {
            sportColumn.setCellEditor(new DefaultCellEditor((JTextField) jComponent));
        }
    }

    public static void addRowJtableDinamic(JTable jTable) {

        JTableDynamicModel dinamicModel = (JTableDynamicModel) jTable.getModel();
        //añadr
        int col = jTable.getSelectedColumn();// Obtengo número de columna seleccionada
        if (col == -1) // Si no hay columna seleccionada
        {
            col = 0;// Selecciono la primera
        }
        /* Ordeno al modelo que añada nueva fila y que escriba texto en la columna col */
        Vector fila_nueva = new Vector();// Nueva fila

        /*** Recorro todas las cols de la nueva fila, sólo pongo el texto en columna col */
        for (int i = 0; i < dinamicModel.getColumnCount(); i++) {
            if (i != col) {
                fila_nueva.add("");
            } else {
                fila_nueva.add("");
            }
        }

        dinamicModel.getFilas().add(fila_nueva);// Añado fila al modelo
        dinamicModel.fireTableRowsInserted(dinamicModel.getFilas().size(), dinamicModel.getFilas().size()); // Ordeno a la tabla que se actualice
    }

    public static void removeRowJtableDinamic(JTable jTable) {

        //eliminar
        JTableDynamicModel dinamicModel = (JTableDynamicModel) jTable.getModel();
        int fila = jTable.getSelectedRow();// Obtengo numero de fila seleccionada
        if (fila != -1) // Si hay fila seleccionada
        {
            if(jTable.isEditing()){
                 jTable.getCellEditor().cancelCellEditing();
             }
            dinamicModel.getFilas().remove(fila);
            dinamicModel.fireTableRowsDeleted(fila, fila);

        }else {
            
        }


    }

    public static void LimpiarJTable(JTable jTable) {
        JTableDynamicModel dinamicModel = (JTableDynamicModel) jTable.getModel();
        int a = dinamicModel.getRowCount() - 1;
        //System.out.println(“Tabla “+a);

        for (int i = a; i >= 0; i--) {
            //System.out.println(“i “+i);
            dinamicModel.getFilas().remove(i);
        }
    }


    public static boolean containStringInColumn(JTable jTable,int col,String valueBuscado){

        int num_rows = jTable.getRowCount();
        boolean resp = false;
        //iteramos la tabla
        for(int r=0;r<num_rows;r++){
            String valueTabla = ""+jTable.getValueAt(r, col);

            if(valueTabla.equalsIgnoreCase(valueBuscado)){
                resp = true;
                break;
            }
        }

        return resp;
    }
}
