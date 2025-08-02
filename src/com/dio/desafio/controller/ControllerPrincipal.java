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
 * Classe que recebe as ações do usuário e direciona
 * para a execução.
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
                        Mensagens.mensagemAoUsuario(tela, "Nenhuma opção selecionada...", "Bootcamps - Menu de opções");
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
        Mensagens.mensagemAoUsuario(tela, "Até a próxima!", "Sair");
        this.tela.setVisible(false);
        System.exit(0);
    }

    public Dev getDev(){
        return this.dev;
    }

    public List<Bootcamp> getBootcamps(){
        return this.bootcamps;
    }

    public TelaPrincipal getTela(){
        return this.tela;
    }
}