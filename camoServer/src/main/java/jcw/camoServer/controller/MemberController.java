package jcw.camoServer.controller;

import jcw.camoServer.entity.Member;
import jcw.camoServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 회원 가입
     */
    @PostMapping("/user/signup")
    public Member signUp(@ModelAttribute Member member) {
        log.info("member = {}", member);
        Member joinMember = memberService.join(member);
        log.info("member = {}", joinMember);
        System.out.println(member == joinMember);
        return joinMember;
    }

    /**
     * 모든 회원 조회
     */
    @GetMapping("/user/search/all")
    public List<Member> userList() {
        return memberService.findAll();
    }

    /**
     * id를 통한 회원 검색
     */
    @GetMapping("/user/search/id/{id}")
    public Optional<Member> userSearchById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    /**
     * email을 통한 회원 검색
     */
    @GetMapping("/user/search/email/{email}")
    public Optional<Member> userSearchByEmail(@PathVariable("email") String email) {
        return memberService.findByEmail(email);
    }
}
