package urnaEletronica.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urnaEletronica.project.entities.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
     Partido findByName(String name);
}
