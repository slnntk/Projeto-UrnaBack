package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import urnaEletronica.project.entities.Eleitor;
import urnaEletronica.project.repositories.EleitorRepository;

import java.util.List;
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

    public Eleitor findByTitulo(Long titulo){
        return repository.findByTitulo(titulo);
    }


}
