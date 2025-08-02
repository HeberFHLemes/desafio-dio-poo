package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.controller.ControllerRanking;

public class AcaoVerRanking implements Acao{

    private final ControllerPrincipal controllerPrincipal;

    public AcaoVerRanking(ControllerPrincipal controllerPrincipal){
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public void executar() {
        ControllerRanking.mostrarRanking(controllerPrincipal.getBootcamps());
    }
}
