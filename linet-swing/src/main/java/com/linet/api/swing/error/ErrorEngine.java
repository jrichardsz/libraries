package com.linet.api.swing.error;

import java.io.*;

import javax.swing.*;

public class ErrorEngine{

public static void traceErrorOnUI(Exception exception, boolean mustExit, boolean sendToStandardOutput){
		
		StringWriter errors = new StringWriter();
		exception.printStackTrace(new PrintWriter(errors));
		JOptionPane.showMessageDialog(null, errors.toString());
		
		if(sendToStandardOutput){
			exception.printStackTrace();
		}
		
		if(mustExit){
			System.exit(0);
		}
		
		
	}
	
}
