package com.dio.desafio.controller;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.view.telas.TelaBootcamps;

import javax.swing.*;
import java.util.List;

public interface ControllerVerBootcamps extends IController {

    public static void mostrarTabelaBootcamps(List<Bootcamp> bootcamps){

        TelaBootcamps telaBootcamps = new TelaBootcamps();

        Object[] colunas = new Object[]{
                "Nome",
                "Descrição",
                "Data Inicial",
                "Data Final",
                "Inscritos"
        };

        Object[][] linhas = new Object[bootcamps.size()][colunas.length];
        for (int i = 0; i < bootcamps.size(); i++){
            Bootcamp b = bootcamps.get(i);
            linhas[i] = new Object[]{
                    b.getNome(),
                    b.getDescricao(),
                    b.getDataInicial(),
                    b.getDataFinal(),
                    b.getInscritos().size()
            };
        }

        telaBootcamps.criarTabelaBootcamps(colunas, linhas).setVisible(true);

    }

    public static int mostrarEscolhaBootcamps(List<Bootcamp> bootcamps){
        return bootcamps == null ?
                -1 :
                JOptionPane.showOptionDialog(
                null,
                "Qual Bootcamp você deseja se matricular?",
                "Bootcamps - Matrícula",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                bootcamps.toArray(),
                bootcamps.toArray()[0]
        );
    }
}
