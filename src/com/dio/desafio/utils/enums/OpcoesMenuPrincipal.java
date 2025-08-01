package com.dio.desafio.utils.enums;

public enum OpcoesMenuPrincipal {
    MATRICULAR("Matricular-se em um Bootcamp"),
    CONSULTAR_BOOTCAMP("Consultar Bootcamps disponíveis"),
    PROGREDIR("Progredir em um Bootcamp"),
    RANKING("Ver ranking"),
    SAIR("Sair");

    private final String nomeOpcao;

    OpcoesMenuPrincipal(String nomeOpcao){
        this.nomeOpcao = nomeOpcao;
    }

    @Override
    public String toString(){
        return this.nomeOpcao;
    }
}