package co.autopair.spring.seeders;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.repository.TeamRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class MasterDataSeeder {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private MemberRepository memberRepository;

    public MasterDataSeeder(AddressRepository addressRepository, TeamRepository teamRepository, MemberRepository memberRepository) {
        this.addressRepository = addressRepository;
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    public void run() throws IOException {
        teamSeeder();
        addressSeeder();
        memberSeeder();
    }

    private void addressSeeder() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Address> addressFile
                = objectMapper.readValue(
                new File(
                        "src/main/resources/database-data/address.json")
                , new TypeReference<List<Address>>() {});
        addressRepository.saveAll(addressFile);
    }

    private void memberSeeder() throws IOException {
        String[] name = {"Honda","Nan","Dto","Benz","Nid","Yok","Ice","Hut","Tao","Inn","Pure","Da","Gib","Wut","Nisa","Kritsana","Panu","Kaew","Dun","Nong"};
        String[] position = {"CEO","CMO","CTO","Operation Manager","Admin","Account Manager","Accountant","Admin","Senior Front End Developer","Back End Developer","Front End Developer","Front End Developer","Tester","Data Analyst","Customer Support","Customer Support","Customer Support","Customer Support","Product Specialist","Product Specialist"};
        int[] addressID = {1, 2, 3 ,13 ,14 ,15 ,44 ,45 ,46 ,47, 5, 6, 7, 8, 9 ,10 ,33 ,33 ,22 ,11};
        int[] teamID = {1, 1, 1, 2, 3, 4, 4, 3, 9, 9, 9, 9, 5, 6, 7, 7, 7, 7, 8, 8};
        LinkedList<Member> memberLinkedList = new LinkedList<>();
        Team team = new Team();
        for (int i = 0; i < 20; i++) {
            Member member = new Member();
            member.setAddress(addressRepository.getOne(addressID[i]));
            member.setFirstName(name[i]);
            member.setId(i+1);
            member.setLastName(name[i]);
            member.setNickName(name[i]);
            member.setPosition(position[i]);
            member.setTeam(teamRepository.getOne(teamID[i]));
            memberLinkedList.push(member);
        }
        memberRepository.saveAll(memberLinkedList);

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
            Team team = new Team();
            team.setName(item);
            teamList.push(team);
        }
        teamRepository.saveAll(teamList);
    }
}