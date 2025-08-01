package com.dio.desafio.view.helpers;

import javax.swing.JOptionPane;

public abstract class Mensagens {
    public static void mensagemAoUsuario(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mensagemErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
