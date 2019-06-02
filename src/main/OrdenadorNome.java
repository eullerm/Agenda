/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;

/**
 *
 * @author eulle
 */
public class OrdenadorNome extends Ordenador {
    
    public void compara(Contatos p1, Contatos p2, List agenda, int i, int j){
        if((p1.get_nome()).compareToIgnoreCase(p2.get_nome()) > 0){
                Contatos temp;
                temp = p1;               
                p1=p2;               
                p2=temp;
        }
        agenda.set(i, p1);
        agenda.set(j, p2);
       
    }
}
