package urnaEletronica.project.domain.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_urna")
public class Urna implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @OneToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @OneToOne
    @JoinColumn(name = "eleitor_id")
    private Eleitor eleitor;

    public Urna() {
    }

    public Urna(Long id, Candidato candidato, Partido partido, Eleitor eleitor) {
        this.id = id;
        this.candidato = candidato;
        this.partido = partido;
        this.eleitor = eleitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }
}
