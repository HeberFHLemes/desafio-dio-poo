package com.dio.desafio.view.componentes;

import javax.swing.JComboBox;

public class MenuDeOpcoes extends JComboBox<Object> {

    public MenuDeOpcoes(String[] opcoes){
        this.adicionarOpcoes(opcoes);
    }

    public MenuDeOpcoes(){}

    public void adicionarOpcoes(Object[] opcoes){
        for (Object op : opcoes){
            this.addItem(op);
        }
    }
}