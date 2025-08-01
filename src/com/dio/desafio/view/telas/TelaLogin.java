package com.dio.desafio.view.telas;

import com.dio.desafio.utils.enums.Conta;

import javax.swing.JOptionPane;

public class TelaLogin {

    public static int pedirLogin(){
        return JOptionPane.showOptionDialog(
                null,
                "Acesse sua conta para prosseguir",
                "Login",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Conta.values(),
                Conta.values()[0]
        );
    }

    public static void deslogar(){
        JOptionPane.showMessageDialog(null, "Até a próxima!");
    }

    public static void avisarErroNoLogin(){
        JOptionPane.showMessageDialog(null, "Parece que ocorreu um erro, sentimos muito...\nTente novamente mais tarde!");
    }
}