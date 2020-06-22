package co.autopair.spring.resolver;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.repository.TeamRepository;
import co.autopair.spring.service.TeamService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MemberRepository memberRepository;

    //team
    public List<Team> allTeams() {
        return teamRepository.findAll();
    }

    public Team team(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

//    address
    public List<Address> allAddresses(){
        return addressRepository.findAll();
    }

    public Address address(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    //member
//    public List<Member> allMembers(){
//        return memberRepository.findAll();
//    }
//
//    public Member member(Integer id) {
//        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
//    }
}
