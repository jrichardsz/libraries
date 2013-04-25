package com.rnasystems.api.linet.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * - Richard Osmar Leon Ingaruca
 * - Katerin Vanesa Bernal Punil
 *
 */
public class HandlerUtil {

    public static String getFechaHoraToString() {
        Calendar cal = Calendar.getInstance();
        return (("" + cal.get(Calendar.DATE)).length() == 1 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE)) + "-"
                + (("" + (cal.get(Calendar.MONTH) + 1)).length() == 1 ? "0" + (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1))
                + "-" + cal.get(Calendar.YEAR)
                + " " + (("" + cal.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + cal.get(Calendar.HOUR_OF_DAY) : cal.get(Calendar.HOUR_OF_DAY))
                + "-" + (("" + cal.get(Calendar.MINUTE)).length() == 1 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE)) + "-"
                + (("" + cal.get(Calendar.SECOND)).length() == 1 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND));
    }

    public static String getTabulacion(int num_tab) {
        String temp = "";

        for (int a = 0; a < num_tab; a++) {
            temp += "\t";
        }

        return temp;
    }

    public static String conviertePrimeraLetraMayuscula(String in) {

        //obtenemso la primera letra
        String prim = in.substring(0, 1);
        prim = prim.toUpperCase();
        return prim + in.substring(1, in.length());
    }

    public static void limpiaVector(Vector v) {
        if (v != null && v.size() > 0) {
            v.clear();
        }
    }

    public static String getFechaToAAMMDD() {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");        
        return format.format(d);
    }

    public static String setw(int num, String cad) {
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

    public static int indexOfBeanInArrayList(String valueField, Class cls, ArrayList collecion) {
        int ind = 0;
        try {
            Field f[] = cls.getFields();
            for (int b = 0; b < collecion.size(); b++) {
                for (int a = 0; a < f.length; a++) {
                    if (f[a].get(collecion.get(b)) != null) {
                        if (f[a].get(collecion.get(b)).equals(valueField)) {
                            ind = b;
                        }
                    }
                }
            }

            return ind;

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return -1;
    }

    public static int indexOfBeanInArrayList(String field, String valueField, Class cls, ArrayList collecion) {
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
                                 return ind;
                            }
                        }
                    }
                }
            }

           

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return -1;
    }

    public static void printContentCollectionStrings(Collection<String> strings) {
        for (String s : strings) {
            System.out.println("" + s);
        }
    }
    
    public static String formatoNumero(int i) {
        String num = "";
        if (i < 10) {
            num = "0" + i;
        } else {
            num = "" + i;
        }
        return num;
    }

    public static int getTrimestre(Date date) {
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

    public static String parseRoman(int value) {
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

    public static String getDenoMonth(int mes) {
        String denoMes = "";
        switch (mes) {
            case 0:
                denoMes = "Enero";
                break;
            case 1:
                denoMes = "Enero";
                break;
            case 2:
                denoMes = "Febrero";
                break;
            case 3:
                denoMes = "Marzo";
                break;
            case 4:
                denoMes = "Abril";
                break;
            case 5:
                denoMes = "Mayo";
                break;
            case 6:
                denoMes = "Junio";
                break;
            case 7:
                denoMes = "Julio";
                break;
            case 8:
                denoMes = "Agosto";
                break;
            case 9:
                denoMes = "Setiembre";
                break;
            case 10:
                denoMes = "Octubre";
                break;
            case 11:
                denoMes = "Noviembre";
                break;
            case 12:
                denoMes = "Diciembre";
                break;
        }
        return denoMes;
    }

    public static Object retornaZeroifNull(Object obj) {
        if (obj == null) {
            return 0.0;
        } else {
            return obj;
        }
    }

    public static String convertToCadena(int codigo, int length) {
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

    /**
     *
     * @param numero Cadena que puede o no contener un valor numérico
     * @return boolean true: es un número false: no es un número
     */
    public static boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);//Se intenta pasar la cadena a número

        } catch (NumberFormatException e) {//Si se genera la excepción se retorna false.
            return false;
        }
        return true;//Si no se genera la excepción se retorna true.
    }
    
    /**
     *
     * @param numero Cadena que puede o no contener un valor numérico
     * @return boolean true: es un número false: no es un número
     */
    public static int parseInteger(String numero) {
        try {
            return Integer.parseInt(numero);//Se intenta pasar la cadena a número
            
        } catch (NumberFormatException e) {//Si se genera la excepción se retorna false.
            return -1;
        }
        
    }    

    public static boolean isDouble(String numero) {
        try {
            Double.parseDouble(numero);//Se intenta pasar la cadena a número

        } catch (NumberFormatException e) {//Si se genera la excepción se retorna false.
            return false;
        }
        return true;//Si no se genera la excepción se retorna true.
    }

    public static long numeroDias(Date ini, Date fin) {
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

    public static String fechaHora() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE) + "-" +
                (cal.get(Calendar.MONTH) + 1) +
                "-" + cal.get(Calendar.YEAR) +
                " " + cal.get(Calendar.HOUR_OF_DAY) +
                "-" + cal.get(Calendar.MINUTE) + "-" +
                cal.get(Calendar.SECOND);
    }

    public static String getFechaHoy() {
        String fecha;
        Date fechaHoy = new Date();
        fecha = fechaHoy.getDate() + "/" + (fechaHoy.getMonth() + 1) + "/" + (fechaHoy.getYear() + 1900);
        return fecha;
    }

    public static String getFechaAsString(Date date) {
        String fecha;
        int dia = date.getDate();
        String sdia = null;
        if (("" + dia).length() == 1) {
            sdia = "0" + dia;
        } else {
            sdia = "" + dia;
        }

        int mes = date.getMonth() + 1;
        String smes = null;
        if (("" + mes).length() == 1) {
            smes = "0" + mes;
        } else {
            smes = "" + mes;
        }

        String syear = "" + (date.getYear() + 1900);

        fecha = sdia + " / " + smes + " / " + syear;

        return fecha;
    }
    public static int[] getCoordenadas(String coord){
        
        String[] coordenadas = coord.split(",");
        int[] c = {parseInteger(coordenadas[0]),parseInteger(coordenadas[1])};
        return c;        
    } 
    
    public static void limpiaCollection(Collection c) {
        if (c != null && c.size() > 0) {
            c.clear();
        }
    }    
    
}
