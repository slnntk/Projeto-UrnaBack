package urnaEletronica.project.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import urnaEletronica.project.entities.Eleitor;
import urnaEletronica.project.services.EleitorService;

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


}
