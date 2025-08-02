package com.dio.desafio.controller;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.view.componentes.Tabela;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface ControllerRanking extends IController {

    static void mostrarRanking(List<Bootcamp> bootcamps){

        Set<Dev> devs = new TreeSet<>(
                Comparator.comparingDouble(Dev::getXp)
                        .reversed()
                        .thenComparing(Dev::getNome)
        );

        bootcamps.forEach(b -> devs.addAll(b.getInscritos()));

        int numDevs = devs.size();

        Object[] colunas = new Object[]{
                "Posição",
                "Nome",
                "XP Total"
        };

        Object[][] linhas = new Object[numDevs][colunas.length];
        Object[] devsArray = devs.toArray();
        for (int i = 0; i < numDevs; i++){
            Dev d = (Dev) devsArray[i];
            linhas[i] = new Object[]{
                    i+1,
                    d.getNome(),
                    d.getXp()
            };
        }

        Tabela.criarTabelaPadrao(linhas, colunas).setVisible(true);
    }
}
