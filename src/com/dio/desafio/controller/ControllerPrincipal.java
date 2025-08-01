package com.dio.desafio.controller;

import com.dio.desafio.utils.enums.OpcoesMenuPrincipal;
import com.dio.desafio.view.telas.TelaPrincipal;

import javax.swing.JOptionPane;

/**
 * Classe para controlar o fluxo de escolhas do usuário.
 * Além de receber e enviar dados ao dominio, para aplicação
 * das regras de negócio.
 */
public class ControllerPrincipal {

    public ControllerPrincipal(){}

    private TelaPrincipal tela;

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

    public void direcionar(int index){

        OpcoesMenuPrincipal opcaoEscolhida = OpcoesMenuPrincipal.values()[index];
        switch (opcaoEscolhida){
            case SAIR:
                sair();
                System.exit(0);
            case MATRICULAR:
                break;
            case PROGREDIR:
                break;
            case CONSULTAR_BOOTCAMP:
                break;
            case RANKING:
                break;
            default:
                mensagemAoUsuario("Escolha inválida... Tente novamente.");
                break;
        }
    }

    private void mensagemAoUsuario(String mensagem){
        JOptionPane.showMessageDialog(tela, mensagem);
    }

    private void sair(){
        mensagemAoUsuario("Até a próxima!");
        this.tela.setVisible(false);
    }
}
