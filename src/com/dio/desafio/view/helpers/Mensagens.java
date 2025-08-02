package com.dio.desafio.view.helpers;

import javax.swing.JOptionPane;
import java.awt.Frame;

public abstract class Mensagens {
    public static void mensagemAoUsuario(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mensagemErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagemAoUsuario(Frame framePrincipal, String mensagem, String titulo){
        JOptionPane.showMessageDialog(framePrincipal, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mensagemErro(Frame framePrincipal, String mensagem){
        JOptionPane.showMessageDialog(framePrincipal, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}