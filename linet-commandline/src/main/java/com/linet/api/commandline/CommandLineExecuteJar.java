/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.commandline;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class CommandLineExecuteJar {

    private String path;
    private String nameJar;
    private String mainClass;
    private String error;
    private ArrayList parameters = new ArrayList();
    private Process p;
    private boolean hayError = false;

    public void addParameter(String parameter) {

        parameters.add(parameter);

    }

    public CommandLineExecuteJar(String path, String nameJar, String mainClass) {
        this.path = path;
        this.nameJar = nameJar;
        this.mainClass = mainClass;
    }

    public void executeJarVoid() {

        try {

            p = Runtime.getRuntime().exec(getCmdString());
            prepareErrorExecution();
            p.destroy();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String executeJarReturn() {

        String output = null;

        try {

            p = Runtime.getRuntime().exec(getCmdString());
            BufferedReader s = new BufferedReader(new InputStreamReader(p.getInputStream()));

            output = s.readLine();

            prepareErrorExecution();

            p.destroy();

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return output;

    }

    private String getCmdString() {
        //java -cp "X:\RLEON\My Jobs\lib\AF_PentahoUtil.jar" org.axcessfinancial.etl.pentaho.library.dummy.JarDummy 1 2 3 4 5 6
        String cmd = "java -cp " + "\"" + path + File.separator + nameJar + "\" " + mainClass;

        if (!parameters.isEmpty()) {
            cmd = cmd + " "; // adjuntamos un espacio para la insercion de parametros

            for (int a = 0; a < parameters.size(); a++) {
                String p = (String) parameters.get(a);

                if (a == parameters.size() - 1) {// si es el ultimo parametro
                    cmd += p;
                } else {
                    cmd += p + " ";
                }

            }
        }

        System.out.println("cmd line:" + cmd);
        return cmd;
    }

    private void prepareErrorExecution() {

        try {
            BufferedReader s = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String x = s.readLine();
            while (x != null) {
                hayError = true;
                error += x + "\n";
                x = s.readLine();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getReportExecution() {

        if (hayError) {
            return "ERROR:\n" + error;
        } else {
            return "SUCCESSFUL";
        }

    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getNameJar() {
        return nameJar;
    }

    public void setNameJar(String nameJar) {
        this.nameJar = nameJar;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
