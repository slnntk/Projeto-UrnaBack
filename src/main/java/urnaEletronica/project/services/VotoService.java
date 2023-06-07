package urnaEletronica.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urnaEletronica.project.domain.entities.Voto;
import urnaEletronica.project.domain.entities.Voto;
import urnaEletronica.project.repositories.VotoRepository;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    @Autowired
    private VotoRepository repository;

    public List<Voto> findAll(){
        return repository.findAll();
    }

    public Voto findById(Long id){
        Optional<Voto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Voto not found"));
    }
    public Voto insert(Voto obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Voto update(Long id, Voto obj){
        Optional<Voto> optionalVoto = repository.findById(obj.getId());
        Voto Voto = optionalVoto.get();
        updateData(Voto, obj);
        return repository.save(Voto);
    }

    private void updateData(Voto newObj, Voto obj) {
        newObj.setId(obj.getId());
        newObj.setCandidato(obj.getCandidato());
        newObj.setEleitor(obj.getEleitor());
        newObj.setInstant(obj.getInstant());
    }
    

}
