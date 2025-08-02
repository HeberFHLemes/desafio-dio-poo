package com.dio.desafio.dominio;

import com.dio.desafio.utils.exceptions.NenhumConteudoInscrito;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private double xp = 0d;

    public Dev(String nome){
        this.nome = nome;
    }

    public Dev(){}

    public void inscreverEmBootcamp(Bootcamp bootcamp){
        if (bootcamp == null){ throw new IllegalArgumentException(); }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getInscritos().add(this);
    }

    public Conteudo progredir() throws NenhumConteudoInscrito{
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        if(conteudo.isEmpty()) {
            throw new NenhumConteudoInscrito("Você não está matriculado em nenhum conteúdo!");
        }
        Conteudo conteudoConcluido = conteudo.get();
        this.conteudosConcluidos.add(conteudoConcluido);
        this.conteudosInscritos.remove(conteudoConcluido);

        this.xp += conteudoConcluido.calcularXp();

        return conteudoConcluido;
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next().calcularXp();
        }
        this.xp = soma;
        return soma;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public double getXp(){
        return this.xp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
                Objects.equals(conteudosInscritos, dev.conteudosInscritos)
                && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}