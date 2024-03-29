/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Euller
 */
public class Agenda {
    
    private List<Contatos> minha_agenda;
    
    private DefaultListModel listaContatos;

    public Agenda() {
        minha_agenda = new ArrayList<>();
        listaContatos = new DefaultListModel<Contatos>();
    }
        
    
    public void adicionarAgenda(String nome, int telefone, String email) { 
        Contatos p = new Contatos();
        p.set_nome(nome);
        p.set_telefone(telefone);
        p.set_email(email);
        minha_agenda.add(p);
        listaContatos.addElement(p.get_nome());
    }
    public void removerAgenda(int i){
        this.minha_agenda.remove(i);
    }
    
    public Contatos get_Contato(int i){
        return minha_agenda.get(i);
        
    }
    
    public void ordenarNome(){
        OrdenadorNome ordena = new OrdenadorNome();
        for(int i=0; i<minha_agenda.size()-1; i++){
            for(int j=i+1; j<minha_agenda.size(); j++){
                ordena.compara(minha_agenda.get(i), minha_agenda.get(j), minha_agenda, i, j);
                ordena.comparaLista(listaContatos.get(i).toString(), listaContatos.get(j).toString(), listaContatos, i, j);
            }
        }
        
    }
    
    public void esvaziarAgenda(){
        minha_agenda.clear();
    }
    
    public boolean vazia(){
        return minha_agenda.isEmpty();
    }

    
    public DefaultListModel list() {
        
        return listaContatos;
    }
    
}
