package jcw.CAMO_Server.controller;

import jcw.CAMO_Server.entity.Member;
import jcw.CAMO_Server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/user/signup")
    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name,
                       @RequestParam("phone") String phone, @RequestParam("memberType") int memberType) {
        Member member = new Member(email, password, name, phone, memberType);

        memberService.join(member);
    }

    @GetMapping("/user/search/all")
    public List<Member> userList(){
        return memberService.findAll();
    }

    @GetM
}
