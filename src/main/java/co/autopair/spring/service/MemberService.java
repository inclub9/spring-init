package co.autopair.spring.service;


import co.autopair.spring.entity.Member;
import co.autopair.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Value
@Service
@RequiredArgsConstructor
public class MemberService {

    MemberRepository MemberRepository;

    public List<Member> findAll() {
        return MemberRepository.findAll();
    }

    public Member find(Integer id) {
        return MemberRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    public Member save(Member member) {
        return MemberRepository.saveAndFlush(member);
    }

    public Member replace(Member member) {
        find(member.getId());
        return MemberRepository.saveAndFlush(member);
    }

    public int updatePosition(Integer id, String position) {
        return MemberRepository.updatePosition(id, position);
    }

    public void delete(Integer id) {
        MemberRepository.deleteById(id);
    }

    public Optional<Collection<Member>> findAllByAddressDistrict(String district) {
        return MemberRepository.findAllByAddress_District(district);
    }

    public List<Member> saveAll(List<Member> memberList) {
        return MemberRepository.saveAll(memberList);
    }

    public Member findById(Integer integer) {
        return MemberRepository.findById(integer).orElseThrow(() -> new RuntimeException("data not found"));
    }

    public List<Member> findAllById(List<Integer> memberId) {
        List<Member> memberList = new ArrayList<>();
        memberId.stream().forEach(id -> {
            Member member = findById(id);
            memberList.add(member);
        });
        return memberList;
    }

    public List<Member> findAllByTeamId(Integer teamId) {
       return MemberRepository.findAllByTeam_id(teamId);
    }
}
