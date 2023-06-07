package urnaEletronica.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urnaEletronica.project.domain.entities.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{

}
