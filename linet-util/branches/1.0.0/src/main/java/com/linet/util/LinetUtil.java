package com.linet.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * - Richard Osmar Leon Ingaruca
 *
 */
public class LinetUtil {

      

    public static String createRepetitionCharacters(int repetitions, String strChar) {
        String temp = "";

        for (int a = 0; a < repetitions; a++) {
            temp += strChar;
        }

        return temp;
    }

    public static String convertFirstLetterToUpperCase(String in) {

        //obtenemso la primera letra
        String prim = in.substring(0, 1);
        prim = prim.toUpperCase();
        return prim + in.substring(1, in.length());
    }
    
    public static String setwLikeC(int num, String cad) {
        String temp = "";

        if (cad.length() < num) {
            for (int a = 0; a < (num - cad.length()); a++) {
                temp += " ";
            }

            return cad + temp;
        } else {

            int nuevo_lengt = num - 3;

            return cad.substring(0, nuevo_lengt) + "   ";
        }
    }

    public static String[] joinArrays(String[] first, String[] second) {
        List<String> both = new ArrayList<String>(first.length + second.length);
        Collections.addAll(both, first);
        Collections.addAll(both, second);
        return both.toArray(new String[]{});
    }

    public static int indexOfBeanInArrayList(String valueField, Class<?> cls, ArrayList<?> collecion) throws Exception {
        int ind = 0;
        try {
            Field f[] = cls.getFields();
            for (int b = 0; b < collecion.size(); b++) {
                for (int a = 0; a < f.length; a++) {
                    if (f[a].get(collecion.get(b)) != null) {
                        if (f[a].get(collecion.get(b)).equals(valueField)) {
                            ind = b;
                            break;
                        }
                    }
                }
            }

            return ind;

        } catch (Exception ex) {
            throw new Exception("Error when try to search["+valueField+"] in ArrayList.",ex);
        }

    }

    public static int indexOfBeanInArrayList(String field, String valueField, Class<?> cls, ArrayList<?> collecion) throws Exception {
        int ind = 0;
        
        if(collecion.isEmpty()){
            return -1;
        }
        
        try {
            Field f[] = cls.getFields();
            for (int b = 0; b < collecion.size(); b++) {
                for (int a = 0; a < f.length; a++) {

                    if (f[a].getName().equals(field)) {
                        if (f[a].get(collecion.get(b)) != null) {
                            if (f[a].get(collecion.get(b)).equals(valueField)) {
                                ind = b;
                                break;
                            }
                        }
                    }
                }
            }

        return ind;   

        } catch (Exception ex) {
        	throw new Exception("Error when try to search["+valueField+"] in ArrayList.",ex);
        }
    }
    
    public static String formatLengthNumber(int i) {
        String num = "";
        if (i < 10) {
            num = "0" + i;
        } else {
            num = "" + i;
        }
        return num;
    }

    @SuppressWarnings("deprecation")
    public static int getQuarterOfYear(Date date) {
        int trim = 1;
        int mes = date.getMonth();
        if (mes <= 3) {
            if (mes == 1) {
                trim = 4;
            } else {
                trim = 1;
            }
        } else if (mes <= 6) {
            trim = 2;
        } else if (mes <= 9) {
            trim = 3;
        } else if (mes <= 11) {
            trim = 4;
        }
        return trim;
    }

    public static String parseIntToRomanNumber(int value) {
        switch (value) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            default:
                return "";
        }
    }


    public static String convertNumberToStringWhitZeros(int codigo, int length) {
        String cadena_numero_ini = "" + codigo;// representa el codigo pasado a cadena
        String cadena_con_ceros = "";
        if (cadena_numero_ini.length() > length) {//si el codigo pasado a cadena es mayor al limite establecido
            //lanzar alerta
        } else {
            int numero_ceros = length - cadena_numero_ini.length();
            for (int a = 0; a < numero_ceros; a++) {
                cadena_con_ceros += "0";//crea un acadena con tantos ceros como se necesita
            }             //ahora lo concatenamos con el numero
            cadena_con_ceros += cadena_numero_ini;
        }
        return cadena_con_ceros;
    }

    @SuppressWarnings("deprecation")
	public static long differenceDaysBetweenDates(Date ini, Date fin) {
        // Dias de diferencia entre dos fechas
        Calendar cal1 = Calendar.getInstance();
        cal1.set(ini.getYear() + 1900, ini.getMonth() + 1, ini.getDate()); // 21 de Noviembre de 2000
        Calendar cal2 = Calendar.getInstance();
        cal2.set(fin.getYear() + 1900, fin.getMonth() + 1, fin.getDate()); // 28 de Noviembre de 2000
        Date date1 = cal1.getTime();
        Date date2 = cal2.getTime();
        // mira el metodo getTime de la clase Date
        // te devuelve el numero de milisegundos desde el 1 de Enero de 1970
        long dif = date2.getTime() - date1.getTime();
        // Un dia tiene 86400000 milisegundos
        //System.out.println("Dias entre las 2 fechas: " + dif / 86400000L);
        return (dif / 86400000L);
    }

    
    public static void cleanCollection(Collection<?> c) {
        if (c != null && c.size() > 0) {
            c.clear();
        }
    }    
    
}
