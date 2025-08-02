package com.dio.desafio.controller;

import com.dio.desafio.dominio.Conteudo;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.dominio.Mentoria;
import com.dio.desafio.utils.exceptions.NenhumConteudoInscrito;
import com.dio.desafio.view.helpers.Mensagens;

public interface ControllerProgredir extends IController {

    static void progredir(Dev dev){
        try {
            Conteudo conteudoConcluido = dev.progredir();

            Mensagens.mensagemAoUsuario(
                    "\tConteúdo concluído!\n" +
                            conteudoConcluido.getNome() + "\n" +
                            conteudoConcluido.getDescricao() + "\n" +
                            (conteudoConcluido instanceof Curso ?
                                    "Carga horária: " + ((Curso) conteudoConcluido).getCargaHoraria()  :
                                    "Data: " + ((Mentoria) conteudoConcluido).getData()
                            ),
                    "Bootcamps - Progressão"
            );

            Mensagens.mensagemAoUsuario(
                    "\tParabéns! Você acaba de concluir " + conteudoConcluido.getNome() + "! \n" +
                            "Seu XP atual: " + dev.getXp() + ".\nContinue assim!",
                    "Bootcamp - Progressão"
            );

        } catch (NenhumConteudoInscrito e){
            Mensagens.mensagemErro("Parece que você não está inscrito em nenhum Bootcamp...\n" +
                    "Aproveite para matricular-se em um agora mesmo!");
        }
    }
}