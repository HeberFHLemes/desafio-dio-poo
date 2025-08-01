package com.dio.desafio.controller;

import com.dio.desafio.controller.strategy.PrincipalRedirectStrategy;
import com.dio.desafio.controller.strategy.RedirectStrategy;
import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.mock.MocksFactory;
import com.dio.desafio.view.helpers.Mensagens;
import com.dio.desafio.view.telas.TelaPrincipal;

import java.util.List;

/**
 * Classe para controlar o fluxo de escolhas do usuário.
 * Além de receber e enviar dados ao dominio, para aplicação
 * das regras de negócio.
 */
public class ControllerPrincipal implements IController {

    private Dev dev;

    private TelaPrincipal tela;

    private final RedirectStrategy redirectStrategy = new PrincipalRedirectStrategy();

    private List<Bootcamp> bootcamps;

    public ControllerPrincipal(){
        this.dev = new Dev("Você");
        this.bootcamps = MocksFactory.criarMocks();
    }

    public void iniciarAplicacao(){
        ControllerPrincipal cp = this;
        this.tela = new TelaPrincipal() {

            @Override
            public void avisarController() {
                this.jButtonSelecionar.addActionListener(e -> {
                    int selecao = this.menu.getSelectedIndex();
                    cp.direcionar(selecao);
                });
            }
        };
        this.tela.avisarController();
        tela.setVisible(true);
    }

    public void direcionar(int escolha){

        redirectStrategy.redirect(escolha, this);
    }

    public void sair(){
        Mensagens.mensagemAoUsuario("Até a próxima!", "Sair");
        this.tela.setVisible(false);
        System.exit(0);
    }

    public void erro(){
        Mensagens.mensagemErro("Escolha inválida, tente novamente.");
    }

    public Dev getDev(){
        return this.dev;
    }

    public List<Bootcamp> getBootcamps(){
        return this.bootcamps;
    }
}
