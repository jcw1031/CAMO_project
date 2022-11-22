package jcw.camo_server.service;

import jcw.camo_server.dto.SignupDto;
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
    public Optional<User> join(SignupDto signupDto) {
        User user = validateDuplicateUser(signupDto);
        log.info("user in service = {}", user);
        //이메일 중복 검증
        userMapper.save(user);
        return userMapper.findByEmail(user.getEmail());
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

    public List<User> findAll() {
        return userMapper.findAll();
    }

}
