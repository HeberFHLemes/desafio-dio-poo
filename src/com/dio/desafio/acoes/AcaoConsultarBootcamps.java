package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.view.componentes.Tabela;
import com.dio.desafio.view.helpers.Mensagens;

import java.util.List;

public class AcaoConsultarBootcamps implements Acao{

    private final ControllerPrincipal controllerPrincipal;

    public AcaoConsultarBootcamps(ControllerPrincipal controllerPrincipal){
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public void executar() {
        Object[] colunas = new Object[]{
                "Nome",
                "Descrição",
                "Data Inicial",
                "Data Final",
                "Inscritos"
        };

        List<Bootcamp> bootcamps = controllerPrincipal.getBootcamps();

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

        if (linhas.length > 0) {
            Tabela.criarTabelaPadrao(linhas, colunas).setVisible(true);
            return;
        }

        Mensagens.mensagemErro(
                "Parece que não há dados suficientes para mostrar a tabela..."
        );
    }
}
