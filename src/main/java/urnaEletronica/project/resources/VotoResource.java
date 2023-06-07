package urnaEletronica.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import urnaEletronica.project.domain.entities.Voto;
import urnaEletronica.project.services.VotoService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/votos")
@CrossOrigin(origins = "http://localhost:63343")
public class VotoResource {

    @Autowired
    private VotoService service;

    @GetMapping
    public ResponseEntity<List<Voto>> findAll(){
        List<Voto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Voto> findById(@PathVariable Long id){
        Voto Voto = service.findById(id);
        return ResponseEntity.ok().body(Voto);
    }

    @PostMapping
    public ResponseEntity<Voto> insert(@RequestBody Voto obj){
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
    public ResponseEntity<Voto> update(@PathVariable Long id, @RequestBody Voto obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
