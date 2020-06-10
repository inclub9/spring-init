package co.autopair.spring.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

    @Autowired
    MasterDataSeeder masterDataSeeder;

    @Override
    public void run(String... args) throws Exception {
        masterDataSeeder.run();
    }
}