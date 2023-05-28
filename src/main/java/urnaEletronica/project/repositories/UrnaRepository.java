package urnaEletronica.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import urnaEletronica.project.domain.entities.Urna;

public interface UrnaRepository extends JpaRepository<Urna, Long> {

}
