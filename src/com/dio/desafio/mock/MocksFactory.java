package com.dio.desafio.mock;

import com.dio.desafio.dominio.Bootcamp;
import com.dio.desafio.dominio.Conteudo;
import com.dio.desafio.dominio.Curso;
import com.dio.desafio.dominio.Dev;
import com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.List;

/**
 * Será responsável pela instanciação dos dados
 * existentes ao iniciar a aplicação,
 * tornando a experiências "mais realista".
 */
public class MocksFactory {

    public static List<Bootcamp> criarMocks(){

        List<Bootcamp> bootcamps = criarBootcamps();
        preencherBootcamps(bootcamps);
        matricularDevs(bootcamps);
        progredirDevs(bootcamps);
        return bootcamps;
    }

    // Aprimorar como são preenchidos os bootcamps, aqui o número é limitado e se sabe qual conteúdo deve ir em qual bootcamp. (arquivo .csv/.txt?)
    private static void preencherBootcamps(List<Bootcamp> bootcamps){

        List<Conteudo> conteudos = criarConteudos();

        // Java Bootcamp
        bootcamps.get(0).getConteudos().addAll(conteudos.subList(0, 2));

        // Spring Bootcamp
        bootcamps.get(1).getConteudos().addAll(conteudos.subList(2, conteudos.size()));
    }

    // Mesma coisa que o método acima.
    private static void matricularDevs(List<Bootcamp> bootcamps){
        List<Dev> devs = criarDevs();

        devs.subList(0, 3).forEach(d -> d.inscreverEmBootcamp(bootcamps.get(0)));
        devs.subList(3, devs.size()).forEach(d -> d.inscreverEmBootcamp(bootcamps.get(1)));
        // bootcamps.get(0).getInscritos().addAll(devs.subList(0, 3));
        // bootcamps.get(1).getInscritos().addAll(devs.subList(3, devs.size()));
    }

    private static void progredirDevs(List<Bootcamp> bootcamps){
        bootcamps.forEach(b -> {
            b.getInscritos().forEach(Dev::progredir);
        });

        bootcamps.get(1).getInscritos().stream().findFirst().ifPresent(Dev::progredir);
        bootcamps.get(1).getInscritos().stream().findAny().ifPresent(Dev::progredir);
    }

    private static List<Conteudo> criarConteudos(){
        return List.of(
                new Curso("Programação Orientada a Objetos", "Todos os conceitos de POO para você programar com uma base sólida.", 8),
                new Mentoria("Mentoria de Java", "Mentoria on-line sobre a linguagem Java", LocalDate.now()),
                new Curso("Autenticação e Segurança com Spring Security", "Proteja suas aplicação do Spring Framework e garanta a proteção de dados pessoais.", 6),
                new Curso("Desenvolvimento de RESTful APIs", "Crie suas primeiras APIs, de forma estrutura e seguindo o padrão REST.", 10),
                new Curso("Seguindo boas práticas em Spring Framework", "Estude as convenções e padrões de desenvolvimento no Spring Framework.", 6)
        );
    }

    private static List<Bootcamp> criarBootcamps(){
        return List.of(
                new Bootcamp("Java Primeiros Passos", "Dê os seus primeiros passos com a linguagem mais robusta do mercado Tech!", 50),
                new Bootcamp("Spring Boot Camp", "Aprende um dos frameworks mais em alta do mercado e crie APIs do zero com o Spring Framework!", 60)
        );
    }

    private static List<Dev> criarDevs() {
        return List.of(
                new Dev("Javeira123"),
                new Dev("João L."),
                new Dev("Renato G."),
                new Dev("WebDev92"),
                new Dev("Felipe.dev"),
                new Dev("Marques")
        );
    }
}
