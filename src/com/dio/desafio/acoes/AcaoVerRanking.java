package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.view.componentes.Tabela;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AcaoVerRanking implements Acao{

    private final ControllerPrincipal controllerPrincipal;

    public AcaoVerRanking(ControllerPrincipal controllerPrincipal){
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public void executar() {

        // TreeSet de "Devs" ordenado (do maior ao menor) pelo XP de cada um, e, se forem iguais, do nome.
        Set<Dev> devs = new TreeSet<>(
                Comparator.comparingDouble(Dev::getXp)
                        .reversed()
                        .thenComparing(Dev::getNome)
        );

        controllerPrincipal.getBootcamps().forEach(
                b -> devs.addAll(b.getInscritos())
        );

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
