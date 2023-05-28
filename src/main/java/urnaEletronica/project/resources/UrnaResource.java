package urnaEletronica.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.services.CandidatoService;
import urnaEletronica.project.services.EleitorService;
import urnaEletronica.project.services.PartidoService;
import urnaEletronica.project.services.UrnaService;

@RestController
@RequestMapping("/urna")
public class UrnaResource {

    @Autowired
    private UrnaService urnaService;

    @PutMapping(value = "/number/{number}/titulo/{titulo}")
    public ResponseEntity<Eleitor> vote(@PathVariable Integer number,@PathVariable Long titulo){
        Eleitor obj;
        obj = urnaService.vote(number, titulo);
        return ResponseEntity.ok().body(obj);
    }
}
