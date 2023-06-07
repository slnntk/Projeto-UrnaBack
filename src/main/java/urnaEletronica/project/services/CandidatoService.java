package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Candidato;
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
                .filter(x -> Objects.equals(x.getNumber(), number))
                .toList();
        Optional<Candidato> candidato = list.stream().findAny();
        return candidato.orElseThrow(() -> new ObjectNotFoundException("Candidato not found"));
    }

    public Candidato insert(Candidato obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Candidato update(Long id, Candidato obj){
        Optional<Candidato> optionalCandidato = repository.findById(obj.getId());
        Candidato Candidato = optionalCandidato.get();
        updateData(Candidato, obj);
        return repository.save(Candidato);
    }

    private void updateData(Candidato newObj, Candidato obj) {
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setNumber(obj.getNumber());
        newObj.setPartido(obj.getPartido());
        newObj.setVotos(obj.getVotos());

    }
    

}
