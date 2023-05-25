package urnaEletronica.project.dto;

import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Partido;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PartidoDTO implements Serializable  {

    private Long id;
    private String name;
    private Set<Candidato> candidatos = new HashSet<>();


    public PartidoDTO() {
    }

    public PartidoDTO(Partido partido) {
        id = partido.getId();
        name = partido.getName();
        candidatos = partido.getCandidatos();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Candidato> getCandidatos() {
        return candidatos;
    }
}
