package com.linet.api.swing.jframe;



import java.awt.Image;
import javax.swing.JFrame;

import com.linet.api.swing.jpanel.JBackgroundPanel;

public class JBackgroundFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JBackgroundPanel container = new JBackgroundPanel();

    public JBackgroundFrame() {
        setContentPane(container);
    }

    public void setImagen(String nombreImagen) {
    	container.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
    	container.setImagen(nuevaImagen);
    }
}
