package jcw.camo_server.service;

import jcw.camo_server.controller.dto.ResponseDTO;
import jcw.camo_server.dto.user.LoginDTO;
import jcw.camo_server.dto.user.SignupDTO;
import jcw.camo_server.dto.user.UserUpdateDTO;
import jcw.camo_server.dto.user.WithdrawalDTO;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;

    /**
     * 회원가입
     */
    @Transactional
    public Optional<User> save(SignupDTO signupDto) {
        ResponseDTO response = validateDuplicatedUser(signupDto.getEmail());
        if (response.getStatus() != 200) {
            throw new IllegalArgumentException(response.getMessage());
        }
        User user = User.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .name(signupDto.getName())
                .phone(signupDto.getPhone())
                .role(0)
                .build();
        log.info("user in service = {}", user);
        userMapper.userSave(user);
        return userMapper.findByEmail(user.getEmail());
    }

    /**
     * email 중복 검증
     */
    @Transactional
    public ResponseDTO validateDuplicatedUser(String userEmail) {
        log.info("check validate = {}", userEmail);
        Optional<User> optionalUser = userMapper.findByEmail(userEmail);
        if (optionalUser.isPresent()) {
            return ResponseDTO.builder()
                    .status(409)
                    .message("이미 존재하는 이메일입니다.")
                    .build();
        } else {
            return ResponseDTO.builder()
                    .status(200)
                    .build();
        }
    }

    /**
     * 로그인
     */
    @Transactional
    public User login(LoginDTO loginDto) {
        Optional<User> optionalUser = userMapper.findByEmail(loginDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(loginDto.getPassword())) {
                return user;
            }
        }
        return null;
    }


    /**
     * email로 user 검색
     */
    public Optional<User> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    /**
     * id로 user 검색
     */
    public Optional<User> findById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * user 리스트 검색
     */
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * user 정보 수정
     */
    @Transactional
    public User userUpdate(final UserUpdateDTO userUpdateDto) {
        Optional<User> optionalUser = userMapper.findById(userUpdateDto.getUserId());
        log.info("optionalUser = {}", optionalUser);
        if (optionalUser.isPresent()) {
            User user = User.builder()
                    .userId(userUpdateDto.getUserId())
                    .password(userUpdateDto.getPassword())
                    .name(userUpdateDto.getName())
                    .phone(userUpdateDto.getPhone())
                    .build();
            log.info("update user = {}", user);
            userMapper.userUpdate(user);
        }
        return userMapper.findById(userUpdateDto.getUserId()).get();
    }

    /**
     * 회원 권한 변경
     */
    @Transactional
    public User userRoleUpdate(final User user) {
        User updatedUser;
        if (user.getRole() == 0) {
            updatedUser = User.builder()
                    .userId(user.getUserId())
                    .role(1).build();
        } else {
            updatedUser = User.builder()
                    .userId(user.getUserId())
                    .role(0).build();
        }
        userMapper.userRoleUpdate(updatedUser);
        return userMapper.findById(user.getUserId()).get();
    }

    /**
     * 회원 삭제
     */
    @Transactional
    public void deleteUser(final WithdrawalDTO withdrawalDto) {
        Optional<User> optionalUser = userMapper.findById(withdrawalDto.getUserId());
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new IllegalArgumentException("해당 회원이 존재하지 않습니다");
        }
        if (user.getPassword().equals(withdrawalDto.getPassword())) {
            log.info("회원 탈퇴 = {}", user);
            userMapper.delete(user);
        } else {
            throw new IllegalArgumentException("비밀번호 오류. 회원 탈퇴 실패");
        }
    }
}
