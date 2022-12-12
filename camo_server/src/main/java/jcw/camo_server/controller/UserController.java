package jcw.camo_server.controller;

import jcw.camo_server.controller.dto.ResponseDTO;
import jcw.camo_server.dto.user.LoginDTO;
import jcw.camo_server.dto.user.SignupDTO;
import jcw.camo_server.dto.user.UserUpdateDTO;
import jcw.camo_server.dto.user.WithdrawalDTO;
import jcw.camo_server.entity.User;
import jcw.camo_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     * @param signupDto 회원가입 DTO
     * @return 회원가입 완료 된 User 객체
     */
    @PostMapping("/signup")
    public User signup(@RequestBody SignupDTO signupDto) {
        log.info("signupDto = {}", signupDto);
        Optional<User> joinUser = userService.save(signupDto);
        log.info("user = {}", joinUser);
        return joinUser.get();
    }

    @GetMapping("/duplicate/{email}")
    public ResponseDTO checkDuplicate(@PathVariable("email") String userEmail) {
        return userService.validateDuplicatedUser(userEmail);
    }

    /**
     * 로그인
     * @param loginDto 회원의 id와 password
     * @return 로그인 성공 시 해당 User 객체
     */
    @PostMapping("/login")
    public User signIn(@RequestBody LoginDTO loginDto) {
        User loginUser = userService.login(loginDto);
        log.info("login user = {}", loginUser);
        return loginUser;
    }

    /**
     * email을 통한 검색
     * @param email 검색할 user의 email
     * @return Optional형 user
     */
    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable("email") String email)  {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            log.info("{}", optionalUser);
            return optionalUser.get();
        } else {
            return null;
        }
    }

    /**
     * user 리스트 조회
     * @return 모든 user 리스트
     */
    @GetMapping("/list")
    public List<User> userList() {
        return userService.findAll();
    }

    /**
     * 회원 정보 수정
     * @param id 정보를 수정할 user의 id
     * @param userUpdateDto 회원 정보 수정 DTO
     * @return 수정 된 User 객체
     */
    @PutMapping("/{id}")
    public User updateUserInfo(@PathVariable("id") final Long id, @RequestBody final UserUpdateDTO userUpdateDto) {
        userUpdateDto.setUserId(id);
        log.info("userUpdateDto = {}", userUpdateDto);
        return userService.userUpdate(userUpdateDto);
    }

    /**
     * 회원 탈퇴
     * @param userId 탈퇴할 회원의 userId
     */
    @DeleteMapping("")
    public void userWithdrawal(@RequestBody WithdrawalDTO withdrawalDto) {
        userService.deleteUser(withdrawalDto);
    }

}
