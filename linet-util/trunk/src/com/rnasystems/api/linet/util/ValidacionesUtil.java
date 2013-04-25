/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rnasystems.api.linet.util;

/**
 *
 * @author RM-RCMJ
 */
public class ValidacionesUtil {

    public static int parseStringIntForce(String cad){
        int num =0;
        try{
            num = Integer.parseInt(cad);
        }catch(Exception e){
            num = 100;
        }
        return num;
    }

}
