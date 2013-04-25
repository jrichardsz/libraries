/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class DateUtil {

    public static String getDateTimeToString() {
        Calendar cal = Calendar.getInstance();
        return (("" + cal.get(Calendar.DATE)).length() == 1 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE)) + "-"
                + (("" + (cal.get(Calendar.MONTH) + 1)).length() == 1 ? "0" + (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1))
                + "-" + cal.get(Calendar.YEAR)
                + " " + (("" + cal.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + cal.get(Calendar.HOUR_OF_DAY) : cal.get(Calendar.HOUR_OF_DAY))
                + "-" + (("" + cal.get(Calendar.MINUTE)).length() == 1 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE)) + "-"
                + (("" + cal.get(Calendar.SECOND)).length() == 1 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND));
    }

    public static String getDateToAAMMDD() {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(d);
    }

    public static String fechaHora() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE) + "-"
                + (cal.get(Calendar.MONTH) + 1)
                + "-" + cal.get(Calendar.YEAR)
                + " " + cal.get(Calendar.HOUR_OF_DAY)
                + "-" + cal.get(Calendar.MINUTE) + "-"
                + cal.get(Calendar.SECOND);
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
    
    public static String getSpanishDenominationOfMonth(int mes) {
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
}
