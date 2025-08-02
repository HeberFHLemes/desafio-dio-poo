package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.view.helpers.Mensagens;
import com.dio.desafio.view.helpers.Seletor;
import com.dio.desafio.view.helpers.SeletorBootcamps;

import java.util.List;

public class AcaoMatricular implements Acao{

    private final ControllerPrincipal controllerPrincipal;
    private final Seletor<Bootcamp> seletorBootcamp;

    public AcaoMatricular(ControllerPrincipal controllerPrincipal, Seletor<Bootcamp> seletorBootcamp){
        this.controllerPrincipal = controllerPrincipal;
        this.seletorBootcamp = new SeletorBootcamps();
    }

    @Override
    public void executar() {

        List<Bootcamp> bootcamps = controllerPrincipal.getBootcamps();

        int escolha = this.seletorBootcamp.selecionar(bootcamps);

        if (escolha == -1){
            Mensagens.mensagemAoUsuario("Nenhum bootcamp selecionado.", "Bootcamps - Matrícula");
            return;
        } else if (escolha >= bootcamps.size()){
            Mensagens.mensagemErro("Opção inválida...");
            return;
        }

        Dev dev = controllerPrincipal.getDev();
        Bootcamp bootcamp = bootcamps.get(escolha);

        if (dev.getConteudosInscritos().containsAll(bootcamp.getConteudos())){
            Mensagens.mensagemErro(
                    "Parece que você já está inscrito no bootcamp: " + bootcamp + "..."
            );
            return;
        } else if (dev.getConteudosConcluidos().containsAll(bootcamp.getConteudos())){
            Mensagens.mensagemErro(
                    "Parece que você já concluiu este bootcamp: " + bootcamp + "...");
            return;
        }

        dev.inscreverEmBootcamp(bootcamp);

        Mensagens.mensagemAoUsuario(
                "Parabéns!\nVocê concluiu a sua matrícula no bootcamp: " + bootcamp + "!",
                "Bootcamps - Matrícula concluída"
        );
    }
}