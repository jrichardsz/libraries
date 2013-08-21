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

/*************************************************************************************
Modelo de datos para un JTable.
Permite añadir y eliminar filas.
 **************************************************************************************/
public class JTableDynamicModel extends AbstractTableModel {

    private Vector filas = new Vector();          // Vector de filas (vector de vectores)
    private Vector columnas = null;       // Vector de columnas

    /*** Constructor: carga datos ***/
    public JTableDynamicModel() {
        cargar_datos_defecto();
    }

    public JTableDynamicModel(Vector columnas) {
        this.columnas = columnas;
        //cargar_datos();
    }

    /**********************************************
     * Carga de datos
     ************************************************/
    void cargar_datos_defecto() {
        /**** Creo el vector que define las columnas ***/

        columnas.add((String) "Campo");
        columnas.add((String) "No null?");
    }

    void cargar_datos() {
        /**** Creo el vector que define las columnas ***/
               //System.out.println("col:"+columnas);
        for(Object col : columnas){
            //System.out.println("add:"+(String) col);
            columnas.add((String) col);    
        }
    }

    public void clean(){
        if(filas!=null && filas.size()>0){
            filas.clear();
        }
        if(columnas!=null && columnas.size()>0){
            columnas.clear();
        }
    }

    /*************** getColumnName() *********************/
    public String getColumnName(int c) {
        return (String) columnas.elementAt(c);
    }

    /*************** getColumnCount() ******************/
    public int getColumnCount() {
        return columnas.size();
    }

    /****************** getRowCount() *******************/
    public int getRowCount() {
        return filas.size();
    }

    /*******************  setValueAt() *********************/
    /*** Llamada automáticamente cuando termina la edición de una celda ***/
    public void setValueAt(Object valor, int fila, int col) {
        Vector v = (Vector) filas.elementAt(fila);
        v.set(col, valor);
    }

    /*******************  getValueAt() *********************/
    public Object getValueAt(int fila, int col) {
        Vector v = (Vector) filas.elementAt(fila);
        return v.elementAt(col);
    }

    /*** Para que todas las celdas sean editables ****/
    public boolean isCellEditable(int fila, int col) {
        return true;
    }

    public Vector getColumnas() {
        return columnas;
    }

    public void setColumnas(Vector columnas) {
        this.columnas = columnas;
    }

    public Vector getFilas() {
        return filas;
    }

    public void setFilas(Vector filas) {
        this.filas = filas;
    }
}    /////////////////////////// Fin de clase HTablaDinamica \\\\\\\\\\\\\\\\\\\\\\\\ºº

