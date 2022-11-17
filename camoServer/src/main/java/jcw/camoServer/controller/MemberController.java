package jcw.camoServer.controller;

import jcw.camoServer.entity.User;
import jcw.camoServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 회원 가입
     */
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        log.info("user = {}", user);
        User joinUser = memberService.join(user);
        log.info("user = {}", joinUser);
        System.out.println(user == joinUser);
        return joinUser;
    }

    /**
     * 모든 회원 조회
     */
    @GetMapping("/search/all")
    public List<User> userList() {
        return memberService.findAll();
    }

    /**
     * id를 통한 회원 검색
     */
    @GetMapping("/id/{id}")
    public Optional<User> userSearchById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    /**
     * email을 통한 회원 검색
     */
    @GetMapping("/email/{email}")
    public Optional<User> userSearchByEmail(@PathVariable("email") String email) {
        log.info("email = {}", email);
        return memberService.findByEmail(email);
    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping("/id/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        Optional<User> member = memberService.findById(id);
        member.ifPresent(value -> memberService.delete(value));
    }
}
