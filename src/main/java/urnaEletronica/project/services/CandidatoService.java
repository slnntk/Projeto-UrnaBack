package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.entities.Candidato;
import urnaEletronica.project.entities.Candidato;
import urnaEletronica.project.repositories.CandidatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    public List<Candidato> findAll(){
        return repository.findAll();
    }

    public Candidato findById(Long id){
        Optional<Candidato> obj = repository.findById(id);
        return obj.get();
    }

    public Candidato findByNumber(Integer number){
        return repository.findByNumber(number);
    }

    public Candidato insert(Candidato obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
