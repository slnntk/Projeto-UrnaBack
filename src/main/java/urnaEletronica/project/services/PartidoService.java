package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.entities.Partido;
import urnaEletronica.project.repositories.PartidoRepository;

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
        return obj.get();
    }

    public Partido findByName(String name){
        return repository.findByName(name);
    }

}
