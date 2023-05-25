package urnaEletronica.project.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import urnaEletronica.project.domain.entities.Partido;
import urnaEletronica.project.services.PartidoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/partidos")
public class PartidoResource {

    @Autowired
    private PartidoService service;

    @GetMapping
    public ResponseEntity<List<Partido>> findAll(){
        List<Partido> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Partido> findById(@PathVariable Long id){
        Partido Partido = service.findById(id);
        return ResponseEntity.ok().body(Partido);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Partido> findByName(@PathVariable String name){
        Partido Partido = service.findByName(name);
        return ResponseEntity.ok().body(Partido);
    }

    @PostMapping
    public ResponseEntity<Partido> insert(@RequestBody Partido obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/id/{id}")
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


}
