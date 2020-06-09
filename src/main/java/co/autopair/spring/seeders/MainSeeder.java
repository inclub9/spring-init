package co.autopair.spring.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

    @Autowired
    TeamSeeder teamSeeder;

    @Override
    public void run(String... args) throws Exception {
        teamSeeder.run();
    }
}