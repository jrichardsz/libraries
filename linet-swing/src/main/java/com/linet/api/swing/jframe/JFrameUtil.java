/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.jframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.linet.util.file.FileUtil;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class JFrameUtil {

    public static void centerJFrame(JFrame  jFrame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - jFrame.getWidth()) / 2;
        int y = (screenSize.height - jFrame.getHeight()) / 2;
        jFrame.setLocation(x, y);
    }    
    
    public static void setDefaultIconApp(JFrame frame) throws Exception{
        ImageIcon img = new ImageIcon(FileUtil.getPathFromWhereApplicationIsRunning()+File.separator+"img"+File.separator+"ico.png");
        setIconApp(frame,img);
    }     
    
    public static void setIconApp(JFrame frame, String internalResourceImage){
    	ImageIcon img =new ImageIcon(JFrameUtil.class.getResource(internalResourceImage));
    	setIconApp(frame,img);
    }       

    public static void setIconApp(JFrame frame, ImageIcon img){
    	frame.setIconImage(img.getImage());
    }       
    
}
