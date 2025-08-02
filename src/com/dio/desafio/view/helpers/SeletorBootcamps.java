package com.dio.desafio.view.helpers;

import com.dio.desafio.dominio.Bootcamp;

import javax.swing.JOptionPane;
import java.awt.Frame;
import java.util.List;

public class SeletorBootcamps implements Seletor<Bootcamp> {

    @Override
    public int selecionar(List<Bootcamp> opcoes, Frame parentComponent) {
        if (opcoes == null || opcoes.isEmpty()){
            return -1;
        }
        Object[] opcoesArray = opcoes.toArray();
        return JOptionPane.showOptionDialog(
                parentComponent,
                "Qual Bootcamp você deseja se matricular?",
                "Bootcamps - Matrícula",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesArray,
                opcoesArray[0]
        );
    }
}
