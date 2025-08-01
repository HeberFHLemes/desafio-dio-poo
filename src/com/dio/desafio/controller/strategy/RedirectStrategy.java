package com.dio.desafio.controller.strategy;

import com.dio.desafio.controller.IController;

public interface RedirectStrategy {

    void redirect(int escolha, IController iController);

}
