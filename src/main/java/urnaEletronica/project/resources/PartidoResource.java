package urnaEletronica.project.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import urnaEletronica.project.entities.Partido;
import urnaEletronica.project.services.PartidoService;

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


}
