package co.autopair.spring.config;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.repository.TeamRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        teamDataInitial();
        memberDataInitial(addressDataInitial());
    }

    private void memberDataInitial(List<Address> addressList) {
        Random rand = new Random();
        String[] name = {"Honda", "Nan", "Dto", "Benz", "Nid", "Yok", "Ice", "Hut", "Tao", "Inn", "Pure", "Da", "Gib", "Wut", "Nisa", "Kritsana", "Panu", "Kaew", "Dun", "Nong"};
        String[] position = {"CEO", "CMO", "CTO", "Operation Manager", "Admin", "Account Manager", "Accountant", "Admin", "Senior Front End Developer", "Back End Developer", "Front End Developer", "Front End Developer", "Tester", "Data Analyst", "Customer Support", "Customer Support", "Customer Support", "Customer Support", "Product Specialist", "Product Specialist"};
        Integer[] teamId = {1, 1, 1, 2, 3, 4, 4, 3, 9, 9, 9, 9, 5, 6, 7, 7, 7, 7, 8, 8};
        List<Member> memberList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Address randomAddress = addressList.get(rand.nextInt(addressList.size()));
            Member member = Member.builder()
                    .id(i + 1)
                    .nickName(name[i])
                    .firstName(name[i])
                    .lastName(name[i])
                    .team(teamRepository.getOne(teamId[i]))
                    .address(randomAddress)
                    .position(position[i])
                    .build();
            memberList.add(member);
        }
        memberRepository.saveAll(memberList);
    }

    private List<Address> addressDataInitial() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Address> addressList
                = objectMapper.readValue(
                new File(
                        "src/main/resources/database-data/address.json")
                , new TypeReference<List<Address>>() {
                });
        return addressRepository.saveAll(addressList);
    }

    private List<Team> teamDataInitial() {
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
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < teams.length; i++) {
            teamList.add(
                    Team.builder().name(teams[i]).build()
            );
        }
        return teamRepository.saveAll(
                teamList
        );
    }
}