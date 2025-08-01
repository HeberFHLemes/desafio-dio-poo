package com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private LocalDate dataFinal;
    private Set<Dev> inscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao, long duracaoEmDias) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataFinal = LocalDate.now().plusDays(duracaoEmDias);
    }

    public String matricularDev(Dev dev) {
        if (inscritos.add(dev)) {
            return "Parabéns, " + dev.getNome() +
                    "! Você concluiu sua matrícula em "
                    + this.getNome() + " com sucesso!";
        }
        return "Sentimos muito, mas não foi possível concluir sua matrícula...\n" +
                "Tente novamente mais tarde.";
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public Set<Dev> getInscritos() {
        return inscritos;
    }

    public void setInscritos(Set<Dev> inscritos) {
        this.inscritos = inscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicial, bootcamp.dataInicial) &&
                Objects.equals(dataFinal, bootcamp.dataFinal) &&
                Objects.equals(inscritos, bootcamp.inscritos) &&
                Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, inscritos, conteudos);
    }
}