package com.dio.desafio.view.componentes;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public interface Tabela {

    static JFrame criarTabelaPadrao(Object[][] linhas, Object[] colunas){
        if (linhas == null || colunas == null){
            throw new IllegalArgumentException("Linhas e Colunas não podem ser nulas...");
        }

        JTable tabela = new JTable(linhas, colunas){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setBounds(10, 10, 600, 400);

        JFrame jFrame = new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane jScrollPane = new JScrollPane(tabela);

        jFrame.add(jScrollPane);
        jFrame.setSize(600, 400);
        return jFrame;
    }
}
