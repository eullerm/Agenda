    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author eulle
 */
public abstract class Ordenador {
   
    public abstract void compara(Contatos p1, Contatos p2, List agenda, int i, int j);
    
    public abstract void comparaLista(String p1, String p2, DefaultListModel lista,int i, int j);
    
}
