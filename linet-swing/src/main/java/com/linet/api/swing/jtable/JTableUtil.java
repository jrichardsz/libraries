/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.jtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


public class JTableUtil {

    public static AbstractTableModel getDynamicModel(ArrayList<String> nombreColumnas) {
        DynamicTableModel temp = new DynamicTableModel(nombreColumnas);
        return temp;
    }

    public static void insertComponentInColumn(JTable jTable, int col, JComponent jComponent) {
        TableColumn sportColumn = jTable.getColumnModel().getColumn(col);
        if (jComponent instanceof JComboBox) {
            sportColumn.setCellEditor(new DefaultCellEditor((JComboBox) jComponent));
        } else if (jComponent instanceof JCheckBox) {
            sportColumn.setCellEditor(new DefaultCellEditor((JCheckBox) jComponent));
        } else if (jComponent instanceof JTextField) {
            sportColumn.setCellEditor(new DefaultCellEditor((JTextField) jComponent));
        }
    }

    public static void addEmptyRow(JTable jTable) {

        DynamicTableModel dynamicModel = (DynamicTableModel) jTable.getModel();

        ArrayList<Object> newRow = new ArrayList<Object>();
        //fill with empty data this row
        for (int i = 0; i < dynamicModel.getColumnCount(); i++) {
        	newRow.add("");
        }
        
        //add this row to model
        dynamicModel.getRows().add(newRow);
        //notify this change
        dynamicModel.fireTableRowsInserted(dynamicModel.getRows().size(), dynamicModel.getRows().size());
    }
    
    public static void addDataRow(JTable jTable, Collection<?> dataRow) throws Exception {

        DynamicTableModel dynamicModel = (DynamicTableModel) jTable.getModel();


        ArrayList<Object> newRow = new ArrayList<Object>();
        
        if(dataRow.size()!=dynamicModel.getColumnCount()){
        	throw new Exception(String.format("The number of columns of data do not match the model. Model[%d] ; Data Row[%d]",dynamicModel.getColumnCount(),dataRow.size()));
        }

        Iterator<?> it = dataRow.iterator();
        
        while(it.hasNext()){
        	newRow.add(it.next());
        }
        
        //add this row to model
        dynamicModel.getRows().add(newRow);
        //notify this change        
        dynamicModel.fireTableRowsInserted(dynamicModel.getRows().size(), dynamicModel.getRows().size()); 
    }

    public static void removeRowJtableDinamic(JTable jTable) {

        //eliminar
        DynamicTableModel dinamicModel = (DynamicTableModel) jTable.getModel();
        int fila = jTable.getSelectedRow();// Obtengo numero de fila seleccionada
        if (fila != -1) // Si hay fila seleccionada
        {
            if(jTable.isEditing()){
                 jTable.getCellEditor().cancelCellEditing();
             }
            dinamicModel.getRows().remove(fila);
            dinamicModel.fireTableRowsDeleted(fila, fila);

        }else {
            
        }


    }

    public static void clearJTable(JTable jTable) {
        DynamicTableModel dinamicModel = (DynamicTableModel) jTable.getModel();
//        int a = dinamicModel.getRowCount() - 1;
//        for (int i = a; i >= 0; i--) {
//            dinamicModel.getRows().remove(i);
//        }
        dinamicModel.clean();
        dinamicModel.fireTableDataChanged();
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
