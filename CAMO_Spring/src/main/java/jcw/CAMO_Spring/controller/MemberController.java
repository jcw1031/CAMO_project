package jcw.CAMO_Spring.controller;

import jcw.CAMO_Spring.domain.Member;
import jcw.CAMO_Spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public Member test() {
        Member member = new Member();
        member.setName("지찬우");
        member.setPassword("jcw1530");
        member.setEmail("jcw001031@gmail.com");
        memberService.join(member);

        member = new Member();
        member.setName("김민수");
        member.setPassword("12341234");
        member.setEmail("kimkim@naver.com");
        memberService.join(member);

        member = new Member();
        member.setName("박지수");
        member.setPassword("asdf@1234");
        member.setEmail("park1234@gmail.com");
        memberService.join(member);

        member = new Member();
        member.setName("엄준식");
        member.setPassword("Ummumm");
        member.setEmail("umm1234@naver.com");
        memberService.join(member);
        return member;
    }

    @GetMapping("/member/all")
    public List<Member> getAllMember(){
        return memberService.findAll();
    }

    @GetMapping("/member/searchByEmail/{email}")
    public Member getMember(@PathVariable("email") String email){
        Optional<Member> member = memberService.findOneByEamil(email);
        return member.get();
    }

    @GetMapping("/member/searchById/{id}")
    public Member getMember(@PathVariable("id") Long id){
        Optional<Member> member = memberService.findOneById(id);
        return member.get();
    }
}
