package urnaEletronica.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urnaEletronica.project.entities.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
     Candidato findByNumber(Integer number);
}
