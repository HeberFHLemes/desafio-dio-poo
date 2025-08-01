package com.dio.desafio.dominio;

public abstract class Conteudo {

    protected static final int XP_PADRAO = 10;

    private String nome;

    private String descricao;

    public Conteudo(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public Conteudo(){}

    public abstract double calcularXp();

    public String getNome() {
        return nome;
    }

    public void setTitulo(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
