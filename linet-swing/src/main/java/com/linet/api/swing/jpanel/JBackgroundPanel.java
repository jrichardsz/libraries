package com.linet.api.swing.jpanel;



import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JBackgroundPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

    public JBackgroundPanel() {
    }

    public JBackgroundPanel(String nombreImagen) {
        if (nombreImagen != null) {
        	image = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        }
    }

    public JBackgroundPanel(Image imagenInicial) {
        if (imagenInicial != null) {
        	image = imagenInicial;
        }
    }

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
        	image = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
        	image = null;
        }

        repaint();
    }

    public void setImagen(Image nuevaImagen) {
    	image = nuevaImagen;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }


}
