package com.dio.desafio.view.helpers;

import java.util.List;

/**
 * Idealmente, a implementação forneceria opções em um JOptionPane,
 * e retornaria o índice da escolha, mas a implementação via interface
 * pode permitir outras formas de implementar.
 * @param <T> Tipo do objeto a ser escolhido.
 */
public interface Seletor<T> {
    int selecionar(List<T> opcoes);
}
