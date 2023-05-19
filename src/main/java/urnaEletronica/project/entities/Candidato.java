package urnaEletronica.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private String nome;
    @Column(nullable = false)
    private int votos = 0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;


    public Candidato() {

    }

    public Candidato(Integer number, String nome, Partido partido) {
        this.number = number;
        this.nome = nome;
        this.partido = partido;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato candidato)) return false;

        if (getId() != null ? !getId().equals(candidato.getId()) : candidato.getId() != null) return false;
        return getNumber() != null ? getNumber().equals(candidato.getNumber()) : candidato.getNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
