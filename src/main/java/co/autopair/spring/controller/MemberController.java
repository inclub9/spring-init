package co.autopair.spring.controller;

import co.autopair.spring.entity.Member;
import co.autopair.spring.repository.MemberRepository;
import co.autopair.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MemberController extends CommonController {
    private final MemberService service;
    private final MemberRepository memberRepository;

    @GetMapping("/Members")
    public List<Member> Members() {
        return service.findAll();
    }

    @GetMapping("/Members/{id}")
    public Member member(@PathVariable int id) {  //automatic type conversion
        return service.find(id);
    }

    @GetMapping("/Members/district/{district}")
    public Optional<Collection<Member>> member(@PathVariable String district) {  //automatic type conversion
        return memberRepository.findAllByAddress_District(district);
    }

    @PostMapping("/Members")
    public Member Members(@RequestBody Member Member) {
        return service.save(Member);
    }

    @PutMapping("/Members")
    public Member replace(@RequestBody Member member) {
        return service.replace(member);
    }


    @PatchMapping("/Members/{id}/position/{position}")
    public int patch(@PathVariable int id, @PathVariable String position) {
        return service.updatePosition(id, position);
    }


    @DeleteMapping("/Members/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
