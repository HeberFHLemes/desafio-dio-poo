package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.controller.ControllerProgredir;

public class AcaoProgredir implements Acao{

    private final ControllerPrincipal controllerPrincipal;

    public AcaoProgredir(ControllerPrincipal controllerPrincipal){
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public void executar() {
        ControllerProgredir.progredir(controllerPrincipal.getDev());
    }
}
