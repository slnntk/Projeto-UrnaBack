package urnaEletronica.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import urnaEletronica.project.entities.Eleitor;
import urnaEletronica.project.repositories.EleitorRepository;

import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EleitorRepository eleitorRepository;

    @Override
    public void run(String... args) throws Exception {

        Eleitor e1 = new Eleitor(null, 2316229L, false);
        Eleitor e2 = new Eleitor(null, 2316230L, false);

        eleitorRepository.saveAll(Arrays.asList(e1, e2));


    }
}
