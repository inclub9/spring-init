package co.autopair.spring.seeders;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.TeamRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class MasterDataSeeder {
    @Autowired
    private TeamRepository teamRepository;
    private AddressRepository addressRepository;

    public MasterDataSeeder(AddressRepository addressRepository, TeamRepository teamRepository) {
        this.addressRepository = addressRepository;
        this.teamRepository = teamRepository;
    }

    public void run() throws IOException {
        teamSeeder();
        addressSeeder();
    }

    private void addressSeeder() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Address> addressFile
                = objectMapper.readValue(
                        new File(
                                "src/main/resources/address.json")
                , new TypeReference<List<Address>>() {});
        addressRepository.saveAll(addressFile);
    }

    private void teamSeeder() {
        String[] teams = {
                "Chief",
                "Operation",
                "Admin",
                "Accountant",
                "Tester",
                "Data",
                "Customer",
                "Product",
                "Developer"
        };
        LinkedList<Team> teamList = new LinkedList<>();
        for (String item : teams) {
            Team team = new Team(item);
            teamList.push(team);
        }
        teamRepository.saveAll(teamList);
    }
}