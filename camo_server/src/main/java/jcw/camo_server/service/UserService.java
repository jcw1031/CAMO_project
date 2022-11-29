package jcw.camo_server.service;

import jcw.camo_server.dto.LoginDto;
import jcw.camo_server.dto.SignupDto;
import jcw.camo_server.dto.UserUpdateDto;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Optional<User> save(SignupDto signupDto) {
        User user = validateDuplicatedUser(signupDto);
        log.info("user in service = {}", user);
        //이메일 중복 검증
        userMapper.userSave(user);
        return userMapper.findByEmail(user.getEmail());
    }

    /**
     * 로그인
     */
    @Transactional
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
    @Transactional
    User validateDuplicatedUser(SignupDto signupDto) {
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

    /**
     * 회원 권한 변경
     */
    @Transactional
    public User userRoleUpdate(User user) {
        if (user.getRole() == 0) {
            user.setRole(1);
        } else {
            user.setRole(0);
        }
        userMapper.userUpdate(user);
        return userMapper.findById(user.getUserId()).get();
    }

    /**
     * 회원 삭제
     */
    @Transactional
    public void deleteUser(Long userId) {
        userMapper.delete(userId);
        log.info("회원 탈퇴 성공 {}", userId);
    }
}
