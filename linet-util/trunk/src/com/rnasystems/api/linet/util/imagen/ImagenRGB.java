/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.util.imagen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author RM-RCMJ
 */
public class ImagenRGB {

    public int[][][] pix;
    public int lx;
    public int ly;
    public BufferedImage im;

    public ImagenRGB(int lx, int ly) {
        this.pix = new int[ly][lx][3];
        this.lx = lx;
        this.ly = ly;
    }

    public ImagenRGB(String nombreArchivo) throws IOException {
        File infile = new File(nombreArchivo);
        im = ImageIO.read(infile);
        int r, g, b, rgb;
        int i, j;

        this.lx = im.getWidth();
        this.ly = im.getHeight();
        this.pix = new int[this.ly][this.lx][3];
        for (i = 0; i < this.ly; i++) {
            for (j = 0; j < this.lx; j++) {
                rgb = im.getRGB(j, i); // color RGB mezclado: R:bits 16-23, B:bits 8-15, B:bits 0-7
                //System.out.println(""+rgb);
                // Ahora, separar las componentes
                r = (rgb >> 16) & 255;//bits 16-23. El &255 deja los ultimos 8 bits.
                g = (rgb >> 8) & 255; //bits 8-15
                b = rgb & 255;      //bits 0-7

                this.pix[i][j][0] = r;
                this.pix[i][j][1] = g;
                this.pix[i][j][2] = b;
            }
        }
    }

    public void graba(String nombreArchivo, String tipo) throws IOException {
        BufferedImage im2 = new BufferedImage(this.lx, this.ly, BufferedImage.TYPE_INT_RGB); // nueva imagen RGB

        int i, j;
        int r, g, b;
        int rgb;
        for (i = 0; i < this.ly; i++) {
            for (j = 0; j < this.lx; j++) {
                r = this.pix[i][j][0]; // color rojo se copia
                g = this.pix[i][j][1]; // color verde se copia
                b = this.pix[i][j][2]; // color azul se copia

                rgb = (r << 16) + (g << 8) + b; // Volver a mezclar las componentes
                im2.setRGB(j, i, rgb);
            }
        }
        File outfile = new File(nombreArchivo);
        ImageIO.write(im2, tipo, outfile);
    }

    public BufferedImage getBufferedImage() throws IOException {
        BufferedImage im2 = new BufferedImage(this.lx, this.ly, BufferedImage.TYPE_INT_RGB); // nueva imagen RGB

        int i, j;
        int r, g, b;
        int rgb;
        for (i = 0; i < this.ly; i++) {
            for (j = 0; j < this.lx; j++) {
                r = this.pix[i][j][0]; // color rojo se copia
                g = this.pix[i][j][1]; // color verde se copia
                b = this.pix[i][j][2]; // color azul se copia

                rgb = (r << 16) + (g << 8) + b; // Volver a mezclar las componentes
                im2.setRGB(j, i, rgb);
            }
        }
        im = im2;
        return im;
    }

    public BufferedImage getIm() {
        return im;
    }

    public void setIm(BufferedImage im) {
        this.im = im;
    }
}
