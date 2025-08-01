package com.dio.desafio.controller;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Mentoria;
import com.dio.desafio.utils.enums.Conta;
import com.dio.desafio.utils.enums.TipoConteudo;
import com.dio.desafio.view.telas.TelaDev;
import com.dio.desafio.view.telas.TelaLogin;

import javax.swing.JOptionPane;
import java.util.Map;

/**
 * Classe para controlar o fluxo de escolhas do usuário.
 * Além de receber e enviar dados ao dominio, para aplicação
 * das regras de negócio.
 */
public class ControllerPrincipal {

    public ControllerPrincipal(){}

    public void iniciarAplicacao(){
        int escolha = TelaLogin.pedirLogin();
        if (escolha == JOptionPane.CLOSED_OPTION) {
            TelaLogin.deslogar();
            return;
        }

        Conta conta = Conta.values()[escolha];
        direcionarUsuario(conta);
    }

    private void direcionarUsuario(Conta conta){
        switch (conta){
            case DEV:
                aplicacaoDev();
                break;
            case ADMIN:
                aplicacaoAdmin();
                break;
            default:
                break;
        }
    }

    private void aplicacaoDev(){
        Bootcamp[] bootcamps = new Bootcamp[]{
                new Bootcamp("Java Primeiros Passos", "Dê os seus primeiros passos com a linguagem mais robusta do mercado Tech!", 50),
                new Bootcamp("Python para Dados", "Pratique a linguagem Python voltado à análise e ciência de dados!", 30),
                new Bootcamp("C# Desktop Bootcamp", "Aprenda a linguagem C# e conheça o ecossistema .NET com este bootcamp!", 55),
                new Bootcamp("Cibercamp #10", "Participe da décima edição e fique por dentro de uma das áreas mais importantes para a tecnologia!", 42),
                new Bootcamp("Spring Boot Camp", "Aprende um dos frameworks mais em alta do mercado e crie APIs do zero com o Spring Framework!", 60)
        };

        Mentoria[] mentorias = new Mentoria[]{

        };

        Curso[] cursos = new Curso[]{

        };

        Map<TipoConteudo, Object[]> conteudos = Map.of(
                TipoConteudo.BOOTCAMP, bootcamps,
                TipoConteudo.MENTORIA, mentorias,
                TipoConteudo.CURSO, cursos
        );

        new TelaDev(conteudos).setVisible(true);
    }

    private void aplicacaoAdmin(){

    }
}
