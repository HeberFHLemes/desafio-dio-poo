package com.dio.desafio.controller;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.view.componentes.Tabela;

import java.util.List;

public interface ControllerVerBootcamps extends IController {

     static void mostrarTabelaBootcamps(List<Bootcamp> bootcamps){

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

        Tabela.criarTabelaPadrao(linhas, colunas).setVisible(true);
    }
}
