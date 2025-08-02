package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;

public class AcaoSair implements Acao{

    private final ControllerPrincipal controller;

    public AcaoSair(ControllerPrincipal controller) {
        this.controller = controller;
    }

    @Override
    public void executar() {
        controller.sair();
    }
}
