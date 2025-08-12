# Projeto Bootcamp DIO - Gestão de Conteúdos e Devs

Descrição do Projeto
Este projeto modela um sistema simples de gestão de bootcamps para desenvolvedores.

A classe Bootcamp representa um curso intensivo com nome, descrição, data inicial e final, e mantém uma lista dos desenvolvedores inscritos (Dev) e dos conteúdos oferecidos (Conteudo).

Conteudo é uma classe abstrata que serve como base para diferentes tipos de conteúdo, como Curso (que tem carga horária) e Mentoria (que tem uma data).

A classe Dev representa um desenvolvedor que pode se inscrever em um bootcamp, acompanhar os conteúdos inscritos, progredir e acumular experiência (XP) conforme conclui os conteúdos.

Cada conteúdo calcula XP baseado em regras específicas: cursos multiplicam um XP padrão pela carga horária; mentorias somam um valor fixo adicional.

## Diagrama de Classes

```mermaid
classDiagram
    class Bootcamp {
        - String nome
        - String descricao
        - LocalDate dataInicial
        - LocalDate dataFinal
        - Set~Dev~ devsInscritos
        - Set~Conteudo~ conteudos
        + adicionarDev(dev)
        + adicionarConteudo(conteudo)
        + getNome()
        + setNome(nome)
        + getDescricao()
        + setDescricao(descricao)
    }

    class Conteudo {
        <<abstract>>
        - String titulo
        - String descricao
        + calcularXp() : double
        + getTitulo()
        + setTitulo(titulo)
        + getDescricao()
        + setDescricao(descricao)
    }

    class Curso {
        - int cargaHoraria
        + calcularXp() : double
        + getCargaHoraria()
        + setCargaHoraria(cargaHoraria)
    }

    class Mentoria {
        - LocalDate data
        + calcularXp() : double
        + getData()
        + setData(data)
    }

    class Dev {
        - String nome
        - Set~Conteudo~ conteudosInscritos
        - Set~Conteudo~ conteudosConcluidos
        + inscreverBootcamp(bootcamp)
        + progredir() : boolean
        + calcularTotalXp() : double
    }

    Bootcamp "1" --> "*" Dev : inscreve
    Bootcamp "1" --> "*" Conteudo : possui
    Conteudo <|-- Curso
    Conteudo <|-- Mentoria
    Dev "1" --> "*" Conteudo : inscritos
    Dev "1" --> "*" Conteudo : concluidos
