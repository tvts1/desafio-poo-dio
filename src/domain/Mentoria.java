package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Conteudo{

    private LocalDate data;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mentoria)) return false;
        Mentoria mentoria = (Mentoria) o;
        return Objects.equals(getTitulo(), mentoria.getTitulo()) &&
                Objects.equals(getDescricao(), mentoria.getDescricao()) &&
                Objects.equals(data, mentoria.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getDescricao(), data);
    }
}
