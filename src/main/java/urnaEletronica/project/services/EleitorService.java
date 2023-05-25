package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.repositories.EleitorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EleitorService {

    @Autowired
    private EleitorRepository repository;

    public List<Eleitor> findAll(){
        return repository.findAll();
    }

    public Eleitor findById(Long id){
        Optional<Eleitor> obj = repository.findById(id);
        return obj.get();
    }

    public Eleitor findByTitulo(Long number){
        List<Eleitor> list = findAll()
                .stream()
                .filter(x -> Objects.equals(x.getTitulo(), number))
                .toList();
        Optional<Eleitor> eleitor = list.stream().findAny();
        findById(eleitor.get().getId());
        return eleitor.get();
    }

    public Eleitor insert(Eleitor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
