package urnaEletronica.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_voto")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Eleitor eleitor;
    @OneToOne
    private Candidato candidato;
    private Instant instant;


    public Voto(Long id, Eleitor eleitor, Candidato candidato, Instant instant) {
        this.id = id;
        this.eleitor = eleitor;
        this.candidato = candidato;
        this.instant = Instant.now();
    }

    public Voto(Eleitor eleitor, Candidato candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
        this.instant = Instant.now();
    }

    public Voto() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @JsonBackReference
    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voto voto)) return false;

        return getEleitor() != null ? getEleitor().equals(voto.getEleitor()) : voto.getEleitor() == null;
    }

    @Override
    public int hashCode() {
        return getEleitor() != null ? getEleitor().hashCode() : 0;
    }
}
