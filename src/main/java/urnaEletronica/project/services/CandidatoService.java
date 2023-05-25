package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.repositories.CandidatoRepository;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    public List<Candidato> findAll(){
        return repository.findAll();
    }

    public Candidato findById(Long id){
        Optional<Candidato> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Candidato not found"));
    }

    public Candidato findByNumber(Integer number){
        List<Candidato> list = findAll()
                .stream()
                .filter(x -> x.getNumber() == number)
                .toList();
        Optional<Candidato> candidato = list.stream().findAny();
        findById(candidato.get().getId());
        return candidato.get();
    }

    public Candidato insert(Candidato obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
