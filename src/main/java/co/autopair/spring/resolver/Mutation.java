package co.autopair.spring.resolver;

import co.autopair.spring.entity.Address;
import co.autopair.spring.entity.Member;
import co.autopair.spring.entity.Team;
import co.autopair.spring.service.AddressService;
import co.autopair.spring.service.MemberService;
import co.autopair.spring.service.TeamService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public List<Member> addMembersToTeam(Long teamId, List<Member> members) {
        List<Member> memberList = new ArrayList<>();
        members.stream().forEach(member -> {
            Member memberItem =
                    member.builder()
                            .id(member.getId())
                            .nickName(member.getNickName())
                            .firstName(member.getFirstName())
                            .lastName(member.getLastName())
                            .position(member.getPosition())
                            .leader(member.getLeader())
                            .team(teamService.save(member.getTeam()))
                            .address(addressService.save(member.getAddress()))
                            .build();
            memberList.add(memberItem);

        });
        return memberService.saveAll(memberList);
    }

    public List<Member> removeTeamOfMember(List<Integer> memberIds) {
        List<Member> memberList = new ArrayList<>();
        memberIds.stream().forEach(memberId -> {
            Member member = memberService.find(memberId);
            member.setTeam(null);
            memberList.add(member);
        });
        return memberService.saveAll(memberList);
    }

    public List<Member> removeMemberInTeam(Integer teamId, List<Integer> memberId) {
        List<Member> memberList = memberService.findAllByTeamId(teamId);
        List<Member> memberListToSave = new ArrayList<>();
        memberList.stream().forEach(member -> {
            member.setTeam(null);
            memberListToSave.add(member);
        });
        memberService.saveAll(memberListToSave);
        return memberService.findAll();
    }

    public List<Member> updateTeamOfMember(List<Integer> memberId, List<Team> teams) {
        if (memberId.size() == teams.size()) {
            List<Team> teamList = teamService.findAllOrCreate(teams);
            List<Member> memberList = memberService.findAllById(memberId);
            for (int i = 0; i < memberList.size(); i++) {
                memberList.get(i).setTeam(teamList.get(i));
            }
            return memberService.saveAll(memberList);
        }
        return null;
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
