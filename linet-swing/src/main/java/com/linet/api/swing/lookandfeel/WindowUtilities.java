package com.linet.api.swing.lookandfeel;

import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;

/** A few utilities that simplify using windows in Swing.
 *  1998-99 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */
public class WindowUtilities {

    /** Tell system to use native look and feel, as in previous
     *  releases. Metal (Java) LAF is the default otherwise.
     * @throws Exception 
     */
    public static void setNativeLookAndFeel() throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new Exception("Error when setting native LAF: " + e);
        }
    }

    public static void setJavaLookAndFeel() throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
        	throw new Exception("Error when setting Java LAF: " + e);
        }
    }

    public static void setJavaDefaultLookAndFeelDecorated() throws Exception {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
        	throw new Exception("Error when setting Java LAF: " + e);
        }
    }

    public static void setMotifLookAndFeel() throws Exception {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
        	throw new Exception("Error when setting Motif LAF: " + e);
        }
    }

    public static void setNimbusLookAndFeel() throws Exception {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
        	throw new Exception("Error when setting Nimbus LAF: ",e);
        } catch (ClassNotFoundException e) {
        	throw new Exception("Error when setting Nimbus LAF: ",e);
        } catch (InstantiationException e) {
        	throw new Exception("Error when setting Nimbus LAF: ",e);
        } catch (IllegalAccessException e) {
        	throw new Exception("Error when setting Nimbus LAF: ",e);
        }
    }

    /** A simplified way to see a JPanel or other Container.
     *  Pops up a JFrame with specified Container as the content pane.
     */
    public static JFrame openInJFrame(Container content,
            int width,
            int height,
            String title,
            Color bgColor) {
        JFrame frame = new JFrame(title);
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        frame.setSize(width, height);
        frame.setContentPane(content);
        frame.setVisible(true);
        return (frame);
    }

    /** Uses Color.white as the background color. */
    public static JFrame openInJFrame(Container content,
            int width,
            int height,
            String title) {
        return (openInJFrame(content, width, height, title, Color.white));
    }

    /** Uses Color.white as the background color, and the
     *  name of the Container's class as the JFrame title.
     */
    public static JFrame openInJFrame(Container content,
            int width,
            int height) {
        return (openInJFrame(content, width, height,
                content.getClass().getName(),
                Color.white));
    }
}
