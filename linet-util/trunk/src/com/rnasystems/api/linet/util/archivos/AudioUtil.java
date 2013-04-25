/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.api.linet.util.archivos;

//import java.applet.AudioClip;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.swing.JApplet;
//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class AudioUtil {

//    public static void playAudio(File f) {
//
//        try {
//            //lo convertimos a url
//            URL u = f.toURL();
//            //Bueno de la AudioClip no se puede instancias por eso esto
//            AudioClip sonido = JApplet.newAudioClip(u);
//            //para que suene
//            sonido.loop();
//            //como el programa se ejecuta muy rapido el audio no se alcanza a escuchar
//            Thread.currentThread().sleep(5000);
//            //si fuese una ventana no fuese necesario esa linea
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//    public static void playAudioFile(String path) {
//
//        try {
//            
//            // Se obtiene un Clip de sonido
//            Clip sonido = AudioSystem.getClip();
//            
//            // Se carga con un fichero wav
//            sonido.open(AudioSystem.getAudioInputStream(new File(path)));
//            
//            // Comienza la reproducción
//            sonido.start();
//            
//            // Espera mientras se esté reproduciendo.
//            while (sonido.isRunning())
//                Thread.sleep(1000);
//            
//            // Se cierra el clip.
//            sonido.close();
//        } catch (Exception e) {
//            System.out.println("" + e);
//        }
//
//    }
//
//    public static void playAudio(String path) {
//
//        try {
//            //lo convertimos a url
//            File f = new File(path);
//            playAudio(f);
//
//            //si fuese una ventana no fuese necesario esa linea
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    public static void playAudio(InputStream inputStream) throws IOException {
//        
//        AudioStream as = new AudioStream(inputStream);
//        
//        AudioData data = as.getData();
//        // Create ContinuousAudioDataStream.
//        ContinuousAudioDataStream cas = new ContinuousAudioDataStream(data);
//        // Play audio.
//        AudioPlayer.player.start(cas);
//
//    }
}
