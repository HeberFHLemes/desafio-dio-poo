package com.dio.desafio.controller;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.view.helpers.Mensagens;

import javax.swing.JOptionPane;
import java.util.List;

public interface ControllerMatricula extends IController{
    public static void matricularDev(Dev dev, List<Bootcamp> bootcamps){
        int escolha = ControllerVerBootcamps.mostrarEscolhaBootcamps(bootcamps);

        if (escolha == -1){
            Mensagens.mensagemAoUsuario("Nenhum bootcamp selecionado.", "Bootcamps - Matrícula");
            return;
        } else if (escolha >= bootcamps.size()){
            Mensagens.mensagemErro("Opção inválida...");
            return;
        }

        Bootcamp bootcamp = bootcamps.get(escolha);
        if (dev.getConteudosInscritos().containsAll(bootcamp.getConteudos())){
            JOptionPane.showMessageDialog(
                    null,
                    "Parece que você já está inscrito no bootcamp " + bootcamp + "...");
            return;
        }
        dev.inscreverEmBootcamp(bootcamps.get(escolha));

        JOptionPane.showMessageDialog(
                null,
                "Parabéns!\nVocê concluiu a sua matrícula no bootcamp " + bootcamp + "!"
        );
    }
}
