package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.domain.entities.Voto;
import urnaEletronica.project.repositories.CandidatoRepository;
import urnaEletronica.project.repositories.EleitorRepository;
import urnaEletronica.project.repositories.PartidoRepository;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

@Service
public class UrnaService{

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private EleitorRepository eleitorRepository;

    @Autowired
    private EleitorService eleitorService;

    @Autowired
    private VotoService votoService;

    @Autowired
    private PartidoRepository partidoRepository;



    public Eleitor vote(Integer numberByCandidate, Long tituloByEleitor){

        try{
            Eleitor obj = eleitorRepository.findByTitulo(tituloByEleitor);
            if (!obj.getHasVoted()){
                Candidato candidato = candidatoRepository.findByNumber(numberByCandidate);
                candidato = voteCandidate(candidato, obj);
                obj = voteEleitor(obj, candidato);
                eleitorService.update(obj.getId(), obj);
                candidatoService.update(candidato.getId(), candidato);
                Voto v = new Voto(obj, candidato);
                votoService.insert(v);
                votoService.update(v.getId(), v);
                return obj;
            }

        } catch (NullPointerException e){
            throw new ObjectNotFoundException("Eleitor not found, vote can't conclude");
        }
        return null;
    }


    private Candidato voteCandidate(Candidato candidato, Eleitor eleitor){
        candidato.setVotos(candidato.getVotos()+1);
        candidato.addEleitor(eleitor);
        return candidato;
    }

    private Eleitor voteEleitor(Eleitor eleitor, Candidato candidato){
        eleitor.setHasVoted(true);
        eleitor.setCandidato(candidato);
        return eleitor;
    }




}
