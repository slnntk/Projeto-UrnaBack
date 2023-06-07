package urnaEletronica.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.services.UrnaService;

@RestController
@RequestMapping(value = "/urna")
@CrossOrigin(origins = "*")
public class UrnaResource {

    @Autowired
    private UrnaService urnaService;

    @PutMapping(value = "/number/{number}/titulo/{titulo}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Eleitor> vote(@PathVariable Integer number,@PathVariable Long titulo){
        Eleitor obj;
        obj = urnaService.vote(number, titulo);
        return ResponseEntity.ok().body(obj);
    }
}
