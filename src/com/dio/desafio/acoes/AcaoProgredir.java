package com.dio.desafio.acoes;

import com.dio.desafio.controller.ControllerPrincipal;
import com.dio.desafio.dominio.Conteudo;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.dominio.Mentoria;
import com.dio.desafio.utils.exceptions.NenhumConteudoInscrito;
import com.dio.desafio.view.helpers.Mensagens;

public class AcaoProgredir implements Acao{

    private final ControllerPrincipal controllerPrincipal;

    public AcaoProgredir(ControllerPrincipal controllerPrincipal){
        this.controllerPrincipal = controllerPrincipal;
    }

    @Override
    public void executar() {
        Dev dev = controllerPrincipal.getDev();
        try {
            Conteudo conteudoConcluido = dev.progredir();

            Mensagens.mensagemAoUsuario(
                    controllerPrincipal.getTela(),
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
                    controllerPrincipal.getTela(),
                    "\tParabéns! Você acaba de concluir " + conteudoConcluido.getNome() + "! \n" +
                            "Seu XP atual: " + dev.getXp() + ".\nContinue assim!",
                    "Bootcamp - Progressão"
            );

        } catch (NenhumConteudoInscrito e){
            Mensagens.mensagemErro(
                    controllerPrincipal.getTela(),
                    "Parece que você não está inscrito em nenhum Bootcamp...\n" +
                    "Aproveite para matricular-se em um agora mesmo!");
        }
    }
}
