package com.dio.desafio.controller;

import com.dio.desafio.strategy.DirecionadorDeAcoes;
import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.mock.MocksFactory;
import com.dio.desafio.view.helpers.Mensagens;
import com.dio.desafio.view.telas.TelaPrincipal;

import javax.swing.SwingUtilities;
import java.util.List;

/**
 * Classe para controlar o fluxo de escolhas do usuário.
 * Além de receber e enviar dados ao dominio, para aplicação
 * das regras de negócio.
 */
public class ControllerPrincipal {

    private final Dev dev; // Usuário

    private final TelaPrincipal tela;

    private final List<Bootcamp> bootcamps;

    private final DirecionadorDeAcoes direcionadorDeAcoes;

    public ControllerPrincipal(){

        this.dev = new Dev("Você");
        this.bootcamps = MocksFactory.criarMocks();

        this.direcionadorDeAcoes = new DirecionadorDeAcoes(this);

        this.tela = criarTelaPrincipal();
    }

    private TelaPrincipal criarTelaPrincipal(){
        ControllerPrincipal cp = this;
        return new TelaPrincipal() {
            {
                this.jButtonSelecionar.addActionListener(e -> {
                    int selecao = this.menu.getSelectedIndex();

                    if (selecao >= 0 && selecao < this.menu.getItemCount()) {
                        cp.direcionar(selecao);
                    } else {
                        Mensagens.mensagemAoUsuario("Nenhuma opção selecionada...", "Bootcamps - Menu de opções");
                    }
                });
            }
        };
    }

    public void iniciarAplicacao(){
        SwingUtilities.invokeLater(() -> tela.setVisible(true));
    }

    public void direcionar(int escolha){
        direcionadorDeAcoes.direcionar(escolha);
    }

    public void sair(){
        Mensagens.mensagemAoUsuario("Até a próxima!", "Sair");
        this.tela.setVisible(false);
        System.exit(0);
    }

    public Dev getDev(){
        return this.dev;
    }

    public List<Bootcamp> getBootcamps(){
        return this.bootcamps;
    }
}