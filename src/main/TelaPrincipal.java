package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TelaPrincipal extends JFrame{
    
  

    public TelaPrincipal(Agenda agenda){
    
        super("Agenda");
        
        TelaExibida(agenda);
       
        
    }
    
    public void TelaExibida(Agenda agenda){
        
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
        JPanel tela = new JPanel();
        tela.setPreferredSize(new Dimension (500, 250));
        tela.setLayout(new BorderLayout());
        
        
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension (250, 250));
        container.setLayout(new BorderLayout());
        //Botoes
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(240, 70));
        panel.setLayout( new GridBagLayout());
        GridBagConstraints local = new GridBagConstraints();
        //Cria botão
        JButton adiciona = new JButton("Adicionar");
        JButton remove = new JButton("Remover");
        JButton atualiza = new JButton("Atualizar");
        JButton apaga = new JButton("Apagar agenda");
        JButton exibe = new JButton("Exibir");
        JButton OK = new JButton("OK");
        //Coloca o tamanho
        adiciona.setPreferredSize(new Dimension(120, 20));
        remove.setPreferredSize(new Dimension(120, 20));
        atualiza.setPreferredSize(new Dimension(120, 20));
        apaga.setPreferredSize(new Dimension(120, 20));
        exibe.setPreferredSize(new Dimension(120, 20));
        OK.setPreferredSize(new Dimension(120, 20));
        //Adiciona uma fonte
        adiciona.setFont(new Font("Arial", Font.BOLD, 10));
        remove.setFont(new Font("Arial", Font.BOLD, 10));
        atualiza.setFont(new Font("Arial", Font.BOLD, 10));
        apaga.setFont(new Font("Arial", Font.BOLD, 10));
        exibe.setFont(new Font("Arial", Font.BOLD, 10));
        OK.setFont(new Font("Arial", Font.BOLD, 10));
        //OK.setOpaque(false);
        //OK.setContentAreaFilled(false);
        OK.setEnabled(false);
        //Coloca no panel
        local.anchor = GridBagConstraints.SOUTHEAST;
        local.gridx = 0;
        local.gridy = 0;
        panel.add(exibe, local);
        local.gridx = 1;
        local.gridy = 0;
        panel.add(OK, local);
        local.gridx = 0;
        local.gridy = 1;
        panel.add(adiciona, local);
        local.gridx = 0;
        local.gridy = 2;
        panel.add(remove, local);
        local.gridx = 1;
        local.gridy = 1;
        panel.add(atualiza, local);
        local.gridx = 1;
        local.gridy = 2;
        panel.add(apaga, local);
        
        //
        JPanel info = new JPanel();
        JLabel nome = new JLabel("Nome: ");
        JLabel numero = new JLabel("Numero: ");
        JLabel email = new JLabel("E-mail: ");
        
        JTextField linha1 = new JTextField (20);
        JTextField linha2 = new JTextField (20);
        JTextField linha3 = new JTextField (20);
        
        info.add(nome);
        info.add(linha1);
        info.add(numero);
        info.add(linha2);
        info.add(email);
        info.add(linha3);
        
        container.add(info);
        container.add(panel, BorderLayout.SOUTH);
        
        //Scroll dos contatos
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(240, 210));
        JList lista = new JList (agenda.list());
        lista.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll= new JScrollPane (lista);
        scroll.setPreferredSize(new Dimension(240, 210));
        panel2.add(scroll);
        
        tela.add(panel2, BorderLayout.WEST);
        tela.add(container, BorderLayout.EAST);
        this.add(tela);
        revalidate();
        
        adiciona.addActionListener((ActionEvent e) -> {
            agenda.adicionarAgenda(linha1.getText(), linha2.getText(), linha3.getText());
            agenda.ordenarNome();
            getContentPane().removeAll();
            TelaExibida(agenda);
            
        });
        
        remove.addActionListener((ActionEvent e) -> {
            int selecionado = lista.getSelectedIndex();
            if(selecionado!=-1){
                agenda.removerAgenda(selecionado);
                agenda.list().remove(selecionado);
                lista.clearSelection();
            }
            TelaExibida(agenda);
        });
        
        atualiza.addActionListener((ActionEvent e) -> {

            int selecionado = lista.getSelectedIndex();
            if(selecionado!=-1){
                linha1.setText(agenda.get_Contato(selecionado).get_nome());
                linha2.setText(agenda.get_Contato(selecionado).get_telefone());
                linha3.setText(agenda.get_Contato(selecionado).get_email());
                agenda.removerAgenda(selecionado);
                agenda.list().remove(selecionado);
            }
            OK.setEnabled(true);
            OK.addActionListener((ActionEvent o) -> {
                
                agenda.adicionarAgenda(linha1.getText(), linha2.getText(), linha3.getText());
                agenda.ordenarNome();
                getContentPane().removeAll();
                TelaExibida(agenda);
                
            });

        });
        
        apaga.addActionListener((ActionEvent e) -> {
            
            if(!agenda.vazia()){
                agenda.esvaziarAgenda();
                agenda.list().clear();
            }
            TelaExibida(agenda);
        });
        
        exibe.addActionListener((ActionEvent e) -> {
            
            int selecionado = lista.getSelectedIndex();
            if(selecionado!=-1){
                linha1.setText(agenda.get_Contato(selecionado).get_nome());
                linha2.setText(agenda.get_Contato(selecionado).get_telefone());
                linha3.setText(agenda.get_Contato(selecionado).get_email());
            }
        });
    }
   


}
