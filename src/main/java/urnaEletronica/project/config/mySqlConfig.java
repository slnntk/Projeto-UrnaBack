package urnaEletronica.project.config;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    private EntityManager entityManager;
    @Autowired
    private EleitorRepository eleitorRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private PartidoRepository partidoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Eleitor> eleitores = new ArrayList<>();

        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            Long titulo = (long) (100000000 + random.nextInt(900000000));
            Boolean hasVoted = false;
            Eleitor eleitor = new Eleitor(titulo, hasVoted);
            eleitores.add(eleitor);
        }

        List<Partido> partidos = new ArrayList<>();

        Partido partido1 = new Partido("Partido da Natureza");
        Partido partido2 = new Partido("Partido dos Animais");

        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato(1, "Avestruz", partido1));
        candidatos.add(new Candidato(2, "Águia", partido1));
        candidatos.add(new Candidato(3, "Burro", partido1));
        candidatos.add(new Candidato(4, "Borboleta", partido1));
        candidatos.add(new Candidato(5, "Cachorro", partido1, "https://i.imgur.com/jDimNTZ.jpeg"));
        candidatos.add(new Candidato(6, "Cabra", partido2));
        candidatos.add(new Candidato(7, "Carneiro", partido2));
        candidatos.add(new Candidato(8, "Camelo", partido2));
        candidatos.add(new Candidato(9, "Cobra", partido2));
        candidatos.add(new Candidato(10, "Coelho", partido2));
        candidatos.add(new Candidato(11, "Cavalo", partido1));
        candidatos.add(new Candidato(12, "Elefante", partido1));
        candidatos.add(new Candidato(13, "Galo", partido1));
        candidatos.add(new Candidato(14, "Gato", partido1));
        candidatos.add(new Candidato(15, "Jacaré", partido1));
        candidatos.add(new Candidato(16, "Leão", partido2));
        candidatos.add(new Candidato(17, "Macaco", partido2));
        candidatos.add(new Candidato(18, "Porco", partido2));
        candidatos.add(new Candidato(19, "Pavão", partido2));
        candidatos.add(new Candidato(20, "Peru", partido2));
        candidatos.add(new Candidato(21, "Touro", partido1));
        candidatos.add(new Candidato(22, "Tigre", partido1));
        candidatos.add(new Candidato(23, "Urso", partido1));
        candidatos.add(new Candidato(24, "Veado", partido1));
        candidatos.add(new Candidato(25, "Vaca", partido1));

        partidos.add(partido1);
        partidos.add(partido2);


        eleitorRepository.saveAll(eleitores);
        partidoRepository.saveAll(partidos);
        candidatoRepository.saveAll(candidatos);

        System.out.println("DRF - CONFIG USED (MYSQL DATABASE)");
    }
}
