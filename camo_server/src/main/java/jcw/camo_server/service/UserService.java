package jcw.camo_server.service;

import jcw.camo_server.dto.user.LoginDTO;
import jcw.camo_server.dto.user.SignupDTO;
import jcw.camo_server.dto.user.UserUpdateDTO;
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
    public Optional<User> save(SignupDTO signupDto) {
        User user = validateDuplicatedUser(signupDto);
        log.info("user in service = {}", user);
        //이메일 중복 검증
        userMapper.userSave(user);
        return userMapper.findByEmail(user.getEmail());
    }

    /**
     * email 중복 검증
     */
    @Transactional
    User validateDuplicatedUser(SignupDTO signupDto) {
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
        User updatedUser = null;
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
    public void deleteUser(final Long userId) {
        userMapper.delete(userId);
        log.info("회원 탈퇴 성공 {}", userId);
    }
}
