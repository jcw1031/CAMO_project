package jcw.CAMO_Server.controller;

import jcw.CAMO_Server.entity.Member;
import jcw.CAMO_Server.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/user/signup")
    public Member signUp(@ModelAttribute Member member) {
        log.info("member = {}", member);
        Member joinMember = memberService.join(member);
        log.info("member = {}", joinMember);
        System.out.println(member == joinMember);
        return joinMember;
    }

    @GetMapping("/user/search/all")
    public List<Member> userList(){
        return memberService.findAll();
    }

    /*@GetMapping("/user/search/id/{id}")
    public Member findById(@PathVariable("id")int id){ }*/

}
