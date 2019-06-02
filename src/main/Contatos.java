/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Euller
 */
public class Contatos {

    private String nome;
    private String telefone;
    private String email;
    
    public Contatos(){
        nome = "";
        telefone = "";
        email = "";
    }
    
    public void set_nome(String nome){
        this.nome = nome;
    }
    
    public void set_telefone(String telefone){
        this.telefone = telefone;
    }
    
    public void set_email(String email){
        this.email = email;
    }
    
    public String get_nome(){
        return nome;
    }
    
    public String get_telefone(){
        return telefone;
    }
    
    public String get_email(){
        return email;
    }
                  
}
