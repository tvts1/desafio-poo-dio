# Projeto Bootcamp DIO - Gestão de Conteúdos e Devs

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
