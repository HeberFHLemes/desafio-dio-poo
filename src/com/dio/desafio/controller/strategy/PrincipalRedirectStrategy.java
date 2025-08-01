package com.dio.desafio.controller.strategy;

import com.dio.desafio.controller.ControllerMatricula;
import com.dio.desafio.controller.ControllerPrincipal;
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
                System.out.println(OpcoesMenuPrincipal.PROGREDIR);
                break;
            case CONSULTAR_BOOTCAMP:
                System.out.println(OpcoesMenuPrincipal.CONSULTAR_BOOTCAMP);
                break;
            case RANKING:
                System.out.println(OpcoesMenuPrincipal.RANKING);
                break;
            default:
                Mensagens.mensagemErro("Escolha inválida... Tente novamente.");
                break;
        }
    }
}
