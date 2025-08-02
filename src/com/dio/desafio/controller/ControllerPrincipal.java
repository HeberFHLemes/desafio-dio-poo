package com.dio.desafio.controller;

import com.dio.desafio.controller.strategy.DirecionadorDeAcoes;
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
public class ControllerPrincipal {

    private Dev dev;

    private TelaPrincipal tela;

    private List<Bootcamp> bootcamps;

    private final DirecionadorDeAcoes direcionadorDeAcoes;

    public ControllerPrincipal(){

        this.dev = new Dev("Você");
        this.bootcamps = MocksFactory.criarMocks();

        this.direcionadorDeAcoes = new DirecionadorDeAcoes(this);

        ControllerPrincipal cp = this;
        this.tela = new TelaPrincipal() {
            {
                this.jButtonSelecionar.addActionListener(e -> {
                    int selecao = this.menu.getSelectedIndex();
                    cp.direcionar(selecao);
                });
            }
        };
    }

    public void iniciarAplicacao(){
        tela.setVisible(true);
    }

    public void direcionar(int escolha){
        direcionadorDeAcoes.direcionar(escolha);
        // redirectStrategy.redirect(escolha, this);
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
