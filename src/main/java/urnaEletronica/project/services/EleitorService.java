package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.repositories.EleitorRepository;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Eleitor not found"));
    }

    public Eleitor findByTitulo(Long number){
        List<Eleitor> list = findAll()
                .stream()
                .filter(x -> Objects.equals(x.getTitulo(), number))
                .toList();
        Optional<Eleitor> eleitor = list.stream().findAny();
        return findById(eleitor.get().getId());
    }

    public Eleitor insert(Eleitor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Eleitor update(Long id, Eleitor obj){
        Optional<Eleitor> optionalEleitor = repository.findById(obj.getId());
        Eleitor eleitor = optionalEleitor.get();
        updateData(eleitor, obj);
        return repository.save(eleitor);
    }

    private void updateData(Eleitor newObj, Eleitor obj) {
        newObj.setId(obj.getId());
        newObj.setTitulo(obj.getTitulo());
        newObj.setHasVoted(obj.getHasVoted());
    }

}
