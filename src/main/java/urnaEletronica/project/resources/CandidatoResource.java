package urnaEletronica.project.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import urnaEletronica.project.entities.Candidato;
import urnaEletronica.project.services.CandidatoService;

import java.util.List;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResource {

    @Autowired
    private CandidatoService service;

    @GetMapping
    public ResponseEntity<List<Candidato>> findAll(){
        List<Candidato> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Candidato> findById(@PathVariable Long id){
        Candidato Candidato = service.findById(id);
        return ResponseEntity.ok().body(Candidato);
    }

    @GetMapping(value = "/number/{number}")
    public ResponseEntity<Candidato> findByNumber(@PathVariable Integer number){
        Candidato Candidato = service.findByNumber(number);
        return ResponseEntity.ok().body(Candidato);
    }


}
