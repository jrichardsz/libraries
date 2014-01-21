
package com.linet.api.swing.jtable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class DynamicTableModel extends AbstractTableModel {

	private static final long serialVersionUID=1L;
	private ArrayList<Object> rows = null;          
    private ArrayList<String> columns = null;  

    public DynamicTableModel(ArrayList<String> columns) {
        this.columns = columns;
        rows = new ArrayList<Object>();
    }
    
    public DynamicTableModel(ArrayList<String> columns, ArrayList<?> rows) {
        this.columns = columns;
    }

    public void clean(){
        if(rows!=null && rows.size()>0){
            rows.clear();
        }
//        if(columns!=null && columns.size()>0){
//            columns.clear();
//        }
    }

    public String getColumnName(int c) {
        return (String) columns.get(c);
    }

    public int getColumnCount() {
        return columns.size();
    }

    public int getRowCount() {
        return rows.size();
    }

    /*** Llamada automáticamente cuando termina la edición de una celda ***/
    @SuppressWarnings("unchecked")
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
        ArrayList<Object> row = (ArrayList<Object>) rows.get(rowIndex);
        row.set(columnIndex, value);
    }

    @SuppressWarnings("unchecked")
	public Object getValueAt(int fila, int col) {
    	ArrayList<Object> row = (ArrayList<Object>) rows.get(fila);
        return row.get(col);
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    public ArrayList<Object> getRows() {
        return rows;
    }

    public void setFilas(ArrayList<Object> rows) {
        this.rows = rows;
    }
}

