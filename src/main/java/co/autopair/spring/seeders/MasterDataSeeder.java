package co.autopair.spring.seeders;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Team;
import co.autopair.spring.dao.AddressDAO;
import co.autopair.spring.dao.MemberDAO;
import co.autopair.spring.dao.TeamDAO;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.repository.TeamRepository;
import co.autopair.spring.service.AddressService;
import co.autopair.spring.service.MemberService;
import co.autopair.spring.service.TeamService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@AllArgsConstructor
public class MasterDataSeeder {
    TeamRepository teamRepository;
    AddressRepository addressRepository;
    MemberRepository memberRepository;
    MemberService memberService;
    TeamService teamService;
    AddressService addressService;

    public void run() throws IOException {
        List<Team> resultSaveFromTeam = teamSeeder();
        List<Address> resultSaveFromAddress = addressSeeder();
        memberSeeder (resultSaveFromTeam,resultSaveFromAddress);
    }

    private List<Address> addressSeeder() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<AddressDAO> addressFileDAO
                = objectMapper.readValue(
                new File(
                        "src/main/resources/database-data/address.json")
                , new TypeReference<List<AddressDAO>>() {
                });
        return addressService.saveAllDAO(addressFileDAO);
    }

    private List<Team> teamSeeder() {
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
        List<TeamDAO> teamDAOList = new ArrayList<>();
        for (int i = 0; i < teams.length; i++) {
            TeamDAO teamDAO = TeamDAO.builder()
                    .id(i + 1)
                    .name(teams[i])
                    .build();
            teamDAOList.add(teamDAO);
        }
       return teamService.saveAll(teamDAOList);
    }

    private void memberSeeder(List<Team> resultSaveFromTeam, List<Address> resultSaveFromAddress) {
        String[] name = {"Honda", "Nan", "Dto", "Benz", "Nid", "Yok", "Ice", "Hut", "Tao", "Inn", "Pure", "Da", "Gib", "Wut", "Nisa", "Kritsana", "Panu", "Kaew", "Dun", "Nong"};
        String[] position = {"CEO", "CMO", "CTO", "Operation Manager", "Admin", "Account Manager", "Accountant", "Admin", "Senior Front End Developer", "Back End Developer", "Front End Developer", "Front End Developer", "Tester", "Data Analyst", "Customer Support", "Customer Support", "Customer Support", "Customer Support", "Product Specialist", "Product Specialist"};
        List<MemberDAO> memberDAOList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MemberDAO memberDAO = MemberDAO.builder()
                    .id(i + 1)
                    .nickName(name[i])
                    .firstName(name[i])
                    .lastName(name[i])
                    .team(teamRepository.randomData(1))
                    .address(addressRepository.randomData(1))
                    .position(position[i])
                    .build();
            memberDAOList.add(memberDAO);
        }
        memberService.saveAll(memberDAOList);
    }

}