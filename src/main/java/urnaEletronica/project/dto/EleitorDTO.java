package urnaEletronica.project.dto;

import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;

import java.io.Serial;
import java.io.Serializable;

public class EleitorDTO implements Serializable  {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long titulo;
    private Boolean hasVoted;
    private Candidato candidato;

    public EleitorDTO(Eleitor eleitor) {
        id = eleitor.getId();
        titulo = eleitor.getTitulo();
        hasVoted = eleitor.getHasVoted();
        candidato = eleitor.getCandidato();
    }

    public EleitorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
