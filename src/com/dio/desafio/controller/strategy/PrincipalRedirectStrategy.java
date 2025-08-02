package com.dio.desafio.controller.strategy;

import com.dio.desafio.controller.ControllerMatricula;
import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.controller.ControllerProgredir;
import com.dio.desafio.controller.ControllerRanking;
import com.dio.desafio.controller.ControllerVerBootcamps;
import com.dio.desafio.controller.IController;
import com.dio.desafio.utils.enums.OpcoesMenuPrincipal;
import com.dio.desafio.view.helpers.Mensagens;

public class PrincipalRedirectStrategy implements RedirectStrategy{

    @Override
    public void redirect(int escolha, IController iController) {

        ControllerPrincipal controller = (ControllerPrincipal) iController;

        OpcoesMenuPrincipal opcaoEscolhida = OpcoesMenuPrincipal.values()[escolha];

        switch (opcaoEscolhida){
            case SAIR:
                controller.sair();
                break;
            case MATRICULAR:
                ControllerMatricula.matricularDev(controller.getDev(), controller.getBootcamps());
                break;
            case PROGREDIR:
                ControllerProgredir.progredir(controller.getDev());
                break;
            case CONSULTAR_BOOTCAMP:
                ControllerVerBootcamps.mostrarTabelaBootcamps(controller.getBootcamps());
                break;
            case RANKING:
                ControllerRanking.mostrarRanking(controller.getBootcamps());
                break;
            default:
                Mensagens.mensagemErro("Escolha inválida...");
                break;
        }
    }
}
