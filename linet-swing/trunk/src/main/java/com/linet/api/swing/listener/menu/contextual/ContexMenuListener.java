/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linet.api.swing.listener.menu.contextual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author RM-RCM
 */
public class ContexMenuListener implements ActionListener {

    public ContexMenuListener(JMenuItem[] jMenuItems) {
        this.jMenuItems = jMenuItems;
        insertaFuncionalidad();
    }
    
    public void insertaFuncionalidad(){
        for(JMenuItem item: jMenuItems){
            item.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e) {
//        
//        if(e.getSource()==jMenuItems[0]){
//            System.out.println("texto");
//        }else if(e.getSource()==jMenuItems[1]){
//            System.out.println("coordenadas");
//        }else if(e.getSource()==jMenuItems[2]){
//            System.out.println("dimension");
//        }else if(e.getSource()==jMenuItems[3]){
//            System.out.println("propiedades");
//        }
//        
//        
    }
    
    
    
    public JMenuItem[] jMenuItems;
}
