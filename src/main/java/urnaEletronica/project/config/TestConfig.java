package urnaEletronica.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import urnaEletronica.project.entities.Candidato;
import urnaEletronica.project.entities.Eleitor;
import urnaEletronica.project.entities.Partido;
import urnaEletronica.project.repositories.CandidatoRepository;
import urnaEletronica.project.repositories.EleitorRepository;
import urnaEletronica.project.repositories.PartidoRepository;

import java.util.*;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EleitorRepository eleitorRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Eleitor> eleitores = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            Long titulo = (long) (100000000 + random.nextInt(900000000));
            Boolean hasVoted = false;
            Eleitor eleitor = new Eleitor(titulo, hasVoted);
            eleitores.add(eleitor);
        }

        List<Partido> partidos = new ArrayList<>();

        Partido partido1 = new Partido("Clã Uchiha");
        Partido partido2 = new Partido("Clã Hyuga");

        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato(10, "Gon Freecss", partido1));
        candidatos.add(new Candidato(11, "Killua Zoldyck", partido1));
        candidatos.add(new Candidato(12, "Kurapika", partido1));
        candidatos.add(new Candidato(13, "Leorio Paradinight", partido1));
        candidatos.add(new Candidato(14, "Hisoka Morrow", partido1));
        candidatos.add(new Candidato(20, "Meruem", partido2));
        candidatos.add(new Candidato(21, "Neferpitou", partido2));
        candidatos.add(new Candidato(22, "Chrollo Lucilfer", partido2));
        candidatos.add(new Candidato(23, "Feitan Portor", partido2));
        candidatos.add(new Candidato(24, "Shalnark", partido2));

        partidos.add(partido1);
        partidos.add(partido2);


        eleitorRepository.saveAll(eleitores);
        partidoRepository.saveAll(partidos);
        candidatoRepository.saveAll(candidatos);




    }
}
