package jcw.camoServer.controller;

import jcw.camoServer.dto.LoginDto;
import jcw.camoServer.entity.User;
import jcw.camoServer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        log.info("user = {}", user);
        User joinUser = userService.join(user);
        joinUser.setRole(0);
        log.info("user = {}", joinUser);
        System.out.println(user == joinUser);
        return joinUser;
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto) {
        System.out.println("호출");
        log.info("loginDto = {}", loginDto);
        Optional<User> user = userService.findByEmail(loginDto.getEmail());
        if (user.isPresent() && (user.get().getPassword().equals(loginDto.getPassword()))) {
            return user.get();
        } else {
            return null;
        }
    }

    @GetMapping("/login/{email}")
    public User loginGet(@PathVariable("email") String email, @RequestParam("password") String password) {
        System.out.println("호출");
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            System.out.println("예외 처리");
            return null;
        }
    }

    /**
     * 모든 회원 조회
     */
    @GetMapping("/list")
    public List<User> userList() {
        return userService.findAll();
    }

    /**
     * id를 통한 회원 검색
     */
    @GetMapping("/id/{id}")
    public Optional<User> userSearchById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    /**
     * email을 통한 회원 검색
     */
    @GetMapping("/email/{email}")
    public Optional<User> userSearchByEmail(@PathVariable("email") String email) {
        log.info("email = {}", email);
        return userService.findByEmail(email);
    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping("/id/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        Optional<User> member = userService.findById(id);
        member.ifPresent(value -> userService.delete(value));
    }
}
