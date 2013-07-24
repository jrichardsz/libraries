/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.jtable;

/**
 *
 * @author RCMLEONI-271828
 */
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class JTableDynamic extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Object> tableRows = new Vector<Object>();
    private Vector<Object> tableCols = null;       

    public JTableDynamic(Vector<Object> columnas) {
        this.tableCols = columnas;
    }

    /**********************************************
     * Carga de datos
     ************************************************/
    void cargar_datos_defecto() {
        /**** Creo el vector que define las columnas ***/

        tableCols.add((String) "Campo");
        tableCols.add((String) "No null?");
    }

    void cargar_datos() {
        for(Object col : tableCols){           
            tableCols.add((String) col);    
        }
    }

    /*************** getColumnName() *********************/
    public String getColumnName(int c) {
        return (String) tableCols.elementAt(c);
    }

    public int getColumnCount() {
        return tableCols.size();
    }

    public int getRowCount() {
        return tableRows.size();
    }

    /*** Llamada automáticamente cuando termina la edición de una celda ***/
    public void setValueAt(Object valor, int fila, int col) {
        Vector v = (Vector) tableRows.elementAt(fila);
        v.set(col, valor);
    }

    public Object getValueAt(int fila, int col) {
        Vector v = (Vector) tableRows.elementAt(fila);
        return v.elementAt(col);
    }

    /*** Para que todas las celdas sean editables ****/
    public boolean isCellEditable(int fila, int col) {
        return true;
    }

    public Vector getCols() {
        return tableCols;
    }

    public void setCols(Vector cols) {
        this.tableCols = cols;
    }

    public Vector getRows() {
        return tableRows;
    }

    public void setRows(Vector rows) {
        this.tableRows = rows;
    }
}

