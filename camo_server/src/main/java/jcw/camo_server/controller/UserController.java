package jcw.camo_server.controller;

import jcw.camo_server.dto.SignupDto;
import jcw.camo_server.entity.User;
import jcw.camo_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     * @param signupDto 회원가입 DTO
     * @return 회원가입 완료 된 User 객체
     */
    @PostMapping("/signup")
    public User signup(@RequestBody SignupDto signupDto) {
        log.info("signupDto = {}", signupDto);
        Optional<User> joinUser = userService.join(signupDto);
        log.info("user = {}", joinUser);
        return joinUser.get();
    }

    /**
     * email을 통한 검색
     * @param email 검색할 user의 email
     * @return Optional형 user
     */
    @GetMapping("/email/{email}")
    public User findByEmail(@RequestParam("email") String email)  {
        System.out.println(email);
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    /**
     * user 리스트 조회
     * @return 모든 user 리스트
     */
    public List<User> userList() {
        return userService.findAll();
    }
}
