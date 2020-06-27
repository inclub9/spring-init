package co.autopair.spring.config;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.repository.TeamRepository;
import co.autopair.spring.service.AddressService;
import co.autopair.spring.service.MemberService;
import co.autopair.spring.service.TeamService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {
    @Autowired
    TeamService teamService;
    @Autowired
    AddressService addressService;
    @Autowired
    MemberService memberService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Long start = Calendar.getInstance().getTimeInMillis();
        memberDataInitial(addressDataInitial(), teamDataInitial());
        Long end = Calendar.getInstance().getTimeInMillis();
        log.warn("\n   time = {}", end - start);
    }

    private void memberDataInitial(List<Address> addressList, List<Team> teamList) {
        Random rand = new Random();
        memberService.saveAll(
                Arrays.asList(
                        Member.builder().id(1).nickName("Honda").firstName("Honda")
                                .lastName("Honda").team(teamList.get(0))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("CEO")
                                .build(),
                        Member.builder().id(2).nickName("Nan").firstName("Nan")
                                .lastName("Nan").team(teamList.get(0))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("CMO")
                                .build(),
                        Member.builder().id(3).nickName("Dto").firstName("Dto")
                                .lastName("Dto").team(teamList.get(0))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("CTO")
                                .build(),
                        Member.builder().id(4).nickName("Benz").firstName("Benz")
                                .lastName("Benz").team(teamList.get(1))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Operation Manager")
                                .build(),
                        Member.builder().id(5).nickName("Nid").firstName("Nid")
                                .lastName("Nid").team(teamList.get(2))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Admin")
                                .build(),
                        Member.builder().id(6).nickName("Yok").firstName("Yok")
                                .lastName("Yok").team(teamList.get(3))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Account Manager")
                                .build(),
                        Member.builder().id(7).nickName("Ice").firstName("Ice")
                                .lastName("Ice").team(teamList.get(3))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Account Manager")
                                .build(),
                        Member.builder().id(8).nickName("Hut").firstName("Hut")
                                .lastName("Hut").team(teamList.get(2))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Admin")
                                .build(),
                        Member.builder().id(9).nickName("Tao").firstName("Tao")
                                .lastName("Tao").team(teamList.get(8))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Senior Front End Developer")
                                .build(),
                        Member.builder().id(10).nickName("Inn").firstName("Inn")
                                .lastName("Inn").team(teamList.get(8))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Back End Developer")
                                .build(),
                        Member.builder().id(11).nickName("Pure").firstName("Pure")
                                .lastName("Pure").team(teamList.get(8))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Front End Developer")
                                .build(),
                        Member.builder().id(12).nickName("Da").firstName("Da")
                                .lastName("Da").team(teamList.get(8))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Front End Developer")
                                .build(),
                        Member.builder().id(13).nickName("Gib").firstName("Gib")
                                .lastName("Gib").team(teamList.get(4))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Tester")
                                .build(),
                        Member.builder().id(14).nickName("Wut").firstName("Wut")
                                .lastName("Wut").team(teamList.get(5))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Data Analyst")
                                .build(),
                        Member.builder().id(15).nickName("Nisa").firstName("Nisa")
                                .lastName("Nisa").team(teamList.get(6))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Customer Support")
                                .build(),
                        Member.builder().id(16).nickName("Kritsana").firstName("Kritsana")
                                .lastName("Kritsana").team(teamList.get(6))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Customer Support")
                                .build(),
                        Member.builder().id(17).nickName("Panu").firstName("Panu")
                                .lastName("Panu").team(teamList.get(6))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Customer Support")
                                .build(),
                        Member.builder().id(18).nickName("Kaew").firstName("Kaew")
                                .lastName("Kaew").team(teamList.get(6))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Customer Support")
                                .build(),
                        Member.builder().id(19).nickName("Dun").firstName("Dun")
                                .lastName("Dun").team(teamList.get(7))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Product Specialist")
                                .build(),
                        Member.builder().id(20).nickName("Nong").firstName("Nong")
                                .lastName("Nong").team(teamList.get(7))
                                .address(addressList.get(rand.nextInt(addressList.size())))
                                .position("Product Specialist")
                                .build()
                ));
    }

    private List<Address> addressDataInitial() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return addressService.saveAll(
                objectMapper.readValue(
                        new File("src/main/resources/database-data/address.json")
                        , new TypeReference<List<Address>>() {
                        }
                )
        );
    }

    private List<Team> teamDataInitial() {
        return teamService.saveAll(Arrays.asList(
                Team.builder().name("Chief").build(),
                Team.builder().name("Operation").build(),
                Team.builder().name("Admin").build(),
                Team.builder().name("Accountant").build(),
                Team.builder().name("Tester").build(),
                Team.builder().name("Data").build(),
                Team.builder().name("Customer").build(),
                Team.builder().name("Product").build(),
                Team.builder().name("Developer").build()
        ));
    }
}