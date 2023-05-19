package urnaEletronica.project.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_eleitor")
public class Eleitor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long titulo;
    private Boolean hasVoted;

    public Eleitor() {
    }

    public Eleitor(Long id, Long titulo, Boolean hasVoted) {
        this.id = id;
        this.titulo = titulo;
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "id=" + id +
                ", titulo=" + titulo +
                ", hasVoted=" + hasVoted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eleitor eleitor)) return false;

        return getTitulo() != null ? getTitulo().equals(eleitor.getTitulo()) : eleitor.getTitulo() == null;
    }

    @Override
    public int hashCode() {
        return getTitulo() != null ? getTitulo().hashCode() : 0;
    }

    public Long getTitulo() {
        return titulo;
    }

    public void setTitulo(Long titulo) {
        this.titulo = titulo;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
