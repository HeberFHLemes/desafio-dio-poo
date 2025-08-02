package com.dio.desafio.view.telas;

import com.dio.desafio.utils.enums.OpcoesMenuPrincipal;
import com.dio.desafio.view.componentes.MenuDeOpcoes;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class TelaPrincipal extends JFrame {

    protected MenuDeOpcoes menu  = new MenuDeOpcoes();

    protected JButton jButtonSelecionar = new JButton("Selecionar");

    public TelaPrincipal(){
        super("Bootcamps - Tela Inicial");

        int largura = 600;
        int altura = 400;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(largura, altura);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());

        JLabel jLabelBemVindo = new JLabel("Bem-vindo");
        jLabelBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelBemVindo.setFont(jLabelBemVindo.getFont().deriveFont(Font.BOLD, 32f));

        JPanel jPanelBemVindo = new JPanel(new BorderLayout());
        jPanelBemVindo.add(jLabelBemVindo, BorderLayout.CENTER);
        jPanelBemVindo.setPreferredSize(new Dimension(0, altura / 2));
        add(jPanelBemVindo, BorderLayout.NORTH);

        JPanel jPanelCentral = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel jLabelSelecione = new JLabel("Selecione:");
        jLabelSelecione.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));
        jPanelCentral.add(jLabelSelecione);

        this.menu.adicionarOpcoes(OpcoesMenuPrincipal.values());
        jPanelCentral.add(menu);

        jButtonSelecionar.setEnabled(true);
        jPanelCentral.add(jButtonSelecionar);

        add(jPanelCentral, BorderLayout.CENTER);

        JLabel textoAbaixo = new JLabel("Bootcamps");
        textoAbaixo.setHorizontalAlignment(SwingConstants.CENTER);
        textoAbaixo.setFont(textoAbaixo.getFont().deriveFont(Font.ITALIC, 18f));

        JPanel jPanelTextoAbaixo = new JPanel(new BorderLayout());
        jPanelTextoAbaixo.add(textoAbaixo, BorderLayout.CENTER);
        jPanelTextoAbaixo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(jPanelTextoAbaixo, BorderLayout.SOUTH);
    }
}
/*
private void adicionarComponentes(){
        this.jButtonSelecionar.setEnabled(true);
        this.menu.adicionarOpcoes(OpcoesMenuPrincipal.values());

        add(menu);

        add(jButtonSelecionar);
    }
 */