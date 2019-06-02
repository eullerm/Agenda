/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Euller
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Agenda agenda = new Agenda();
        TelaPrincipal tela = new TelaPrincipal(agenda);
        
        
    }
    
}
