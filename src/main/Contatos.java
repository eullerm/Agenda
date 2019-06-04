/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Euller
 */
public class Contatos {

    private String nome;
    private int telefone;
    private String email;
    
    public Contatos(){
        nome = "";
        telefone = 0;
        email = "";
    }
    
    public void set_nome(String nome){
        this.nome = nome;
    }
    
    public void set_telefone(int telefone){
        this.telefone = telefone;
    }
    
    public void set_email(String email){
        this.email = email;
    }
    
    public String get_nome(){
        return nome;
    }
    
    public int get_telefone(){
        return telefone;
    }
    
    public String get_email(){
        return email;
    }
                  
}
