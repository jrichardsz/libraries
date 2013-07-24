/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.jframe;

import com.linet.util.file.FileUtil;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
    
    public static void setPersonalizedIconApp(JFrame frame){
        ImageIcon img = new ImageIcon(FileUtil.getPathFromWhereApplicationIsRunning()+File.separator+"img"+File.separator+"ico.png");
        frame.setIconImage(img.getImage());
    }     
    
    public static void setIconApp(JFrame frame, String icoFileName){
        ImageIcon img = new ImageIcon(icoFileName);
        frame.setIconImage(img.getImage());
    }       
    
}
