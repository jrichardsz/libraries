/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.util.matematica;

/**
 *
 * @author RM-RCMJ
 */
public class Matriz {

   
    public static void mprint(double[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        System.out.println("array[" + rows + "][" + cols + "] = {");
        for (int i = 0; i < rows; i++) {
            System.out.print("{");
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + a[i][j] + ",");
            }
            System.out.println("},");
        }
        System.out.println(":;");
    }

//    public Matriz suma(Matriz a, Matriz b) {
//        Matriz resultado = new Matriz(a.n);
//        for (int i = 0; i < a.n; i++) {
//            for (int j = 0; j < a.n; j++) {
//                resultado.x[i][j] = a.x[i][j] + b.x[i][j];
//            }
//        }
//        return resultado;
//    }

    public static double[][] multiply(double a[][], double b[][]) {
        // Remember RC, Row-Column.

        int aRows = a.length, aColumns = a[0].length, bRows = b.length, bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] resultant = new double[aRows][bColumns];

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    resultant[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return resultant;

    }

    public static double[][] evaluaFuncion(double a[][]) {
                int aRows = a.length, aColumns = a[0].length;
                double temp[][] = new double[aRows][aColumns];

                for (int i = 0; i < aRows; i++) { // aRow
                    for (int j = 0; j < aColumns; j++) { // aColumn
                        temp[i][j] = Funcion.funcion_logistica(a[i][j]);
                    }
                }
                return temp;
    }

}
