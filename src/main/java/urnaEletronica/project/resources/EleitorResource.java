package urnaEletronica.project.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.services.EleitorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/eleitores")
public class EleitorResource {

    @Autowired
    private EleitorService service;

    @GetMapping
    public ResponseEntity<List<Eleitor>> findAll(){
        List<Eleitor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Eleitor> findById(@PathVariable Long id){
        Eleitor eleitor = service.findById(id);
        return ResponseEntity.ok().body(eleitor);
    }

    @GetMapping(value = "/titulo/{titulo}")
    public ResponseEntity<Eleitor> findByTitulo(@PathVariable Long titulo){
        Eleitor eleitor = service.findByTitulo(titulo);
        return ResponseEntity.ok().body(eleitor);
    }

    @PostMapping
    public ResponseEntity<Eleitor> insert(@RequestBody Eleitor obj){
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


}
