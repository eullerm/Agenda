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
        panel.setPreferredSize(new Dimension(240, 60));
        panel.setLayout( new GridBagLayout());
        GridBagConstraints local = new GridBagConstraints();
        //Cria botão
        JButton adiciona = new JButton("Adicionar");
        JButton remove = new JButton("Remover");
        JButton atualiza = new JButton("Atualizar");
        JButton apaga = new JButton("Apagar agenda");
        //Coloca o tamanho
        adiciona.setPreferredSize(new Dimension(120, 20));
        remove.setPreferredSize(new Dimension(120, 20));
        atualiza.setPreferredSize(new Dimension(120, 20));
        apaga.setPreferredSize(new Dimension(120, 20));
        //Adiciona uma fonte
        adiciona.setFont(new Font("Arial", Font.BOLD, 10));
        remove.setFont(new Font("Arial", Font.BOLD, 10));
        atualiza.setFont(new Font("Arial", Font.BOLD, 10));
        apaga.setFont(new Font("Arial", Font.BOLD, 10));
        //Coloca no panel
        local.anchor = GridBagConstraints.SOUTHEAST;
        local.gridx = 0;
        local.gridy = 0;
        panel.add(adiciona, local);
        local.gridx = 1;
        local.gridy = 0;
        panel.add(remove, local);
        local.gridx = 0;
        local.gridy = 1;
        panel.add(atualiza, local);
        local.gridx = 1;
        local.gridy = 1;
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
        });
        
        apaga.addActionListener((ActionEvent e) -> {
            
            if(!agenda.vazia()){
                agenda.esvaziarAgenda();
                agenda.list().clear();
            }
            TelaExibida(agenda);
        });
    }
   


}
