package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.repositories.CandidatoRepository;
import urnaEletronica.project.repositories.EleitorRepository;
import urnaEletronica.project.repositories.PartidoRepository;

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
    private PartidoRepository partidoRepository;



    public Eleitor vote(Integer numberByCandidate, Long tituloByEleitor){
        Eleitor obj = eleitorRepository.findByTitulo(tituloByEleitor);
        System.out.println(obj);
        if (!obj.getHasVoted()){
            Candidato candidato = candidatoRepository.findByNumber(numberByCandidate);
            candidato = voteCandidate(candidato);
            obj = voteEleitor(obj, candidato);
            eleitorService.update(obj.getId(), obj);
            candidatoService.update(candidato.getId(), candidato);
            return obj;
        }
        return null;
    }

    private Candidato voteCandidate(Candidato candidato){
        candidato.setVotos(candidato.getVotos()+1);
        return candidato;
    }

    private Eleitor voteEleitor(Eleitor eleitor, Candidato candidato){
        eleitor.setHasVoted(true);
        eleitor.setCandidato(candidato);
        return eleitor;
    }




}
