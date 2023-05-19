package urnaEletronica.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urnaEletronica.project.entities.Eleitor;

@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
     Eleitor findByTitulo(Long titulo);
}
