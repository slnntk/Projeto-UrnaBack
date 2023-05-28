package urnaEletronica.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.services.CandidatoService;

import java.net.URI;
import java.util.List;

import urnaEletronica.project.dto.CandidatoDTO;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResource {

    @Autowired
    private CandidatoService service;

    @GetMapping
    public ResponseEntity<List<CandidatoDTO>> findAll(){
        List<Candidato> list = service.findAll();
        List<CandidatoDTO> dtoList = list
                .stream()
                .map(x -> new CandidatoDTO(x))
                .toList();
        return ResponseEntity.ok().body(dtoList);
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

    @PostMapping
    public ResponseEntity<Candidato> insert(@RequestBody Candidato obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping(value = "/id/{id}")
    public ResponseEntity<Candidato> update(@PathVariable Long id, @RequestBody Candidato obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
