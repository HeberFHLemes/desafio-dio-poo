package com.dio.desafio.utils.enums;

import java.util.Optional;

public enum OpcoesMenuPrincipal {
    MATRICULAR("Matricular-se em um Bootcamp"),
    CONSULTAR_BOOTCAMPS("Consultar Bootcamps disponíveis"),
    PROGREDIR("Progredir em um Bootcamp"),
    RANKING("Ver ranking"),
    SAIR("Sair");

    private final String nomeOpcao;

    OpcoesMenuPrincipal(String nomeOpcao){
        this.nomeOpcao = nomeOpcao;
    }

    public static Optional<OpcoesMenuPrincipal> getOpcaoPorNumero(int escolha) {

        OpcoesMenuPrincipal[] opcoes = OpcoesMenuPrincipal.values();

        return (escolha >= 0 && escolha < opcoes.length)
                ? Optional.of(opcoes[escolha])
                : Optional.empty();
    }

    @Override
    public String toString(){
        return this.nomeOpcao;
    }
}