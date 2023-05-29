package urnaEletronica.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_partido")
public class Partido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "partido")
    @JsonIgnoreProperties("partido") // Evita a serialização recursiva do partido em Candidato
    private Set<Candidato> candidatos = new HashSet<>();


    public Partido() {
    }

    public Partido(String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;

        if (getId() != null ? !getId().equals(partido.getId()) : partido.getId() != null) return false;
        return Objects.equals(name, partido.name);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void addCandidato(Candidato candidato) {
        candidatos.add(candidato);
        candidato.setPartido(this);
    }

    public void removeCandidato(Candidato candidato) {
        candidatos.remove(candidato);
        candidato.setPartido(null);
    }

    public Integer getVotosDoPartido() {
        return candidatos
                .stream()
                .map(x -> x.getVotos())
                .reduce(0, (x, y) -> x+y);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Set<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
