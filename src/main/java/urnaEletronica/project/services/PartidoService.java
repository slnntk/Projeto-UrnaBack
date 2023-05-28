package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import urnaEletronica.project.domain.entities.Partido;
import urnaEletronica.project.domain.entities.Partido;
import urnaEletronica.project.repositories.PartidoRepository;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository repository;

    public List<Partido> findAll(){
        return repository.findAll();
    }

    public Partido findById(Long id){
        Optional<Partido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Partido not found"));
    }

    public Partido findByName(String name){
        List<Partido> list = repository.findAll()
                .stream()
                .filter(x -> x.getName().equals(name))
                .toList();
        Optional<Partido> partido = list.stream().findAny();
        findById(partido.get().getId());
        return repository.findByName(name);
    }

    public Partido insert(Partido obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Partido update(Long id, Partido obj){
        Optional<Partido> optionalPartido = repository.findById(obj.getId());
        Partido Partido = optionalPartido.get();
        updateData(Partido, obj);
        return repository.save(Partido);
    }

    private void updateData(Partido newObj, Partido obj) {
        newObj.setId(obj.getId());
        newObj.setCandidatos(obj.getCandidatos());
        newObj.setName(obj.getName());
    }

}
