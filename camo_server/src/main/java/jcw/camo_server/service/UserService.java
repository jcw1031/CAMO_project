package jcw.camo_server.service;

import jcw.camo_server.dto.LoginDto;
import jcw.camo_server.dto.SignupDto;
import jcw.camo_server.dto.UserUpdateDto;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public Optional<User> save(SignupDto signupDto) {
        User user = validateDuplicateUser(signupDto);
        log.info("user in service = {}", user);
        //이메일 중복 검증
        userMapper.userSave(user);
        return userMapper.findByEmail(user.getEmail());
    }

    /**
     * 로그인
     */
    public User login(LoginDto loginDto) {
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
     * email 중복 검증
     */
    private User validateDuplicateUser(SignupDto signupDto) {
        log.info("signupDto in validate = {}", signupDto);
        Optional<User> optionalUser = userMapper.findByEmail(signupDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        } else {
            return User.builder()
                    .email(signupDto.getEmail())
                    .password(signupDto.getPassword())
                    .name(signupDto.getName())
                    .phone(signupDto.getPhone())
                    .role(0)
                    .build();
        }
    }

    /**
     * email로 user 검색
     */
    public Optional<User> findByEmail(String email) {
        return userMapper.findByEmail(email);
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
    public User userUpdate(UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userMapper.findById(userUpdateDto.getUserId());
        log.info("optionalUser = {}", optionalUser);
        User user = optionalUser.get();
        user.setPassword(userUpdateDto.getPassword());
        user.setName(userUpdateDto.getName());
        user.setPhone(userUpdateDto.getPhone());
        log.info("user ={}", user);
        userMapper.userUpdate(user);
        return userMapper.findById(userUpdateDto.getUserId()).get();
    }
}
