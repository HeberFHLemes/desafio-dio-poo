package com.dio.desafio.view.telas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaBootcamps {

    public JFrame criarTabelaBootcamps(Object[] colunas, Object[][] linhas){
        JTable tabela = new JTable(linhas, colunas);
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
