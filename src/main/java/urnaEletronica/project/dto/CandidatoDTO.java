package urnaEletronica.project.dto;

import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Partido;

import java.io.Serial;
import java.io.Serializable;

public class CandidatoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer number;
    private String nome;
    private int votos = 0;
    private Partido partido;

    public CandidatoDTO() {
    }

    public CandidatoDTO(Candidato candidato) {
        id = candidato.getId();
        number = candidato.getNumber();
        nome = candidato.getNome();
        votos = candidato.getVotos();
        partido = candidato.getPartido();
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
