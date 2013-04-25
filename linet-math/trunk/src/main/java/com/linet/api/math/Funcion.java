/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.math;

/**
 *
 * @author RM-RCMJ
 */
public class Funcion {

    public static double funcion_logistica(double x) {
        return 1/(1+Math.exp(-x));
    }

    public static double derivada_funcion_logistica(double x) {
        return x*(1-x);
    }


}
