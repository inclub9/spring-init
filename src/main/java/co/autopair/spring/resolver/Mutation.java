package co.autopair.spring.resolver;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.repository.AddressRepository;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.service.AddressService;
import co.autopair.spring.service.MemberService;
import co.autopair.spring.service.TeamService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TeamService teamService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private MemberService memberService;

    //Team
    public Team createTeam(String name) {
        return teamService.save(
                Team.builder().name(name).build()
        );
    }

    public int updateTeamName(Integer id, String name) {
        return teamService.updateName(id, name);
    }

    public List<Team> deleteTeam(Integer id) {
        teamService.delete(id);
        return teamService.findAll();
    }

    //Address
    public Address createAddress(
            String province,
            String district,
            String subDistrict,
            String postalCode,
            String other
    ) {
        return addressService.save(
                Address.builder()
                        .province(province)
                        .district(district)
                        .subDistrict(subDistrict)
                        .postalCode(postalCode)
                        .other(other)
                        .build()
        );
    }

    public int updateAddressDistrict(Integer id, String district) {
        return addressService.updateDistrict(id, district);
    }

    //member
    public Member createMember(
            Member member
    ) {
        member.setTeam(teamService.save(member.getTeam()));
        member.setAddress(addressService.save(member.getAddress()));
        if (member.getLeader() != null) {
            member.setLeader(memberService.save(member.getLeader()));
        }
        return memberService.save(
                member
        );
    }
}
