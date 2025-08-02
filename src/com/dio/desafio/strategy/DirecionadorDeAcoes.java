package com.dio.desafio.strategy;

import com.dio.desafio.acoes.*;

import com.dio.desafio.controller.ControllerPrincipal;

import com.dio.desafio.utils.enums.OpcoesMenuPrincipal;

import com.dio.desafio.view.helpers.Mensagens;
import com.dio.desafio.view.helpers.SeletorBootcamps;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class DirecionadorDeAcoes {

    private final Map<OpcoesMenuPrincipal, Acao> acoes;

    public DirecionadorDeAcoes(ControllerPrincipal controllerPrincipal){
        this.acoes = new EnumMap<>(OpcoesMenuPrincipal.class);

        acoes.put(OpcoesMenuPrincipal.MATRICULAR, new AcaoMatricular(controllerPrincipal, new SeletorBootcamps()));
        acoes.put(OpcoesMenuPrincipal.CONSULTAR_BOOTCAMPS, new AcaoConsultarBootcamps(controllerPrincipal));
        acoes.put(OpcoesMenuPrincipal.PROGREDIR, new AcaoProgredir(controllerPrincipal));
        acoes.put(OpcoesMenuPrincipal.RANKING, new AcaoVerRanking(controllerPrincipal));
        acoes.put(OpcoesMenuPrincipal.SAIR, new AcaoSair(controllerPrincipal));
    }

    public void direcionar(int escolha){

        OpcoesMenuPrincipal.getOpcaoPorNumero(escolha).ifPresentOrElse(
                opcao -> {
                    Acao acao = acoes.get(opcao);
                    Objects.requireNonNull(acao, String.format("Foi impossível realizar a ação: %s", opcao.name())).executar();
                },
                () -> Mensagens.mensagemAoUsuario(
                        "Opção inválida...",
                        "Bootcamps - Ação não encontrada"
                )
        );
    }
}
