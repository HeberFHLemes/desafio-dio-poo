package com.dio.desafio.view.telas;

import com.dio.desafio.controller.ControllerDev;
import com.dio.desafio.utils.enums.TipoConteudo;
import java.util.Map;


public class TelaDev extends TelaPrincipal{

    private final String[] opcoes = {
            "Matricular-se em um Bootcamp",
            "Progredir em um Bootcamp",
            "Participar de uma mentoria",
            "Consultar Bootcamps disponíveis",
            ""
    };

    private final ControllerDev controllerDev = new ControllerDev();

    public TelaDev(Map<TipoConteudo, Object[]> conteudos) {

        super();

        prepararComponentes();

        avisarController();
    }

    private void prepararComponentes(){
        this.menu.adicionarOpcoes(opcoes);
    }

    @Override
    protected void avisarController() {
        this.jButtonSelecionar.addActionListener(e -> {
            String selecao = this.menu.getStringSelecionada();
            // co.login(login);
        });
    }

}
