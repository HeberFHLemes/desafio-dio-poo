package com.dio.desafio.view.telas;

import com.dio.desafio.view.componentes.MenuDeOpcoes;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public abstract class TelaPrincipal extends JFrame{

    protected MenuDeOpcoes menu  = new MenuDeOpcoes();

    protected JButton jButtonSelecionar = new JButton("Selecionar");

    public TelaPrincipal(){

        setTitle("Bootcamps");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        add(jButtonSelecionar);

        add(menu);

        setLayout(new FlowLayout());
    }

    protected abstract void avisarController();
}
