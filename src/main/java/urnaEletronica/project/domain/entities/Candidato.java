package urnaEletronica.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JsonIgnoreProperties("candidatos") // Evita a serialização recursiva do partido em Candidato
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @OneToMany(mappedBy = "candidato")
    @JsonIgnoreProperties("candidato")
    private Set<Eleitor> eleitores = new HashSet<>();


    public Candidato() {

    }

    public Candidato(Integer number, String nome, Partido partido) {
        this.number = number;
        this.nome = nome;
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", number=" + number +
                ", nome='" + nome + '\'' +
                ", votos=" + votos +
                ", partido=" +  partido +
                '}';
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

    public void addEleitor(Eleitor e){
        getEleitores().add(e);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVotos() {
        return votos;
    }

    @JsonIdentityReference
    public Set<Eleitor> getEleitores() {
        return eleitores;
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

    public void setEleitores(Set<Eleitor> eleitores) {
        this.eleitores = eleitores;
    }
}
