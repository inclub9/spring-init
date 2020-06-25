package co.autopair.spring.resolver;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.service.AddressService;
import co.autopair.spring.service.MemberService;
import co.autopair.spring.service.TeamService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private TeamService teamService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private MemberService memberService;

    //team
    public List<Team> allTeams() {
        return teamService.findAll();
    }

    public Team team(Integer id) {
        return teamService.find(id);
    }

    //    address
    public List<Address> allAddresses() {
        return addressService.findAll();
    }

    public Address address(Integer id) {
        return addressService.find(id);
    }

    //member
    public List<Member> allMembers() {
        return memberService.findAll();
    }

    public Member member(Integer id) {
        return memberService.find(id);
    }
}
