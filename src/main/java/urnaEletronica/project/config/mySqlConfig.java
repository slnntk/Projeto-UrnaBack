package urnaEletronica.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import urnaEletronica.project.domain.entities.Candidato;
import urnaEletronica.project.domain.entities.Eleitor;
import urnaEletronica.project.domain.entities.Partido;
import urnaEletronica.project.repositories.CandidatoRepository;
import urnaEletronica.project.repositories.EleitorRepository;
import urnaEletronica.project.repositories.PartidoRepository;

import java.util.*;

@Configuration
@Profile(value = "drf")
public class mySqlConfig implements CommandLineRunner {

    @Autowired
    private EleitorRepository eleitorRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);


        System.out.println("DRF - CONFIG USED (MYSQL DATABASE)");
        /*

        -> Testar findById -> Eleitores

        eleitores.forEach(System.out::println);
        System.out.println(eleitorRepository.findByTitulo(sc.nextLong()));

        */

        /*

        -> Testar findByNumber -> Candidatos

        candidatos.forEach(System.out::println);
        System.out.println(candidatoRepository.findByNumber(sc.nextInt()));

        */



        /*

        -> Testar findByName -> Partido


        partidos.forEach(System.out::println);
        System.out.println(partidoRepository.findByName(sc.next()));

        */




    }
}
