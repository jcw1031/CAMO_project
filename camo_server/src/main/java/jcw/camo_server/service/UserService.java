package jcw.camo_server.service;

import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public Optional<User> join(User user) {
        validateDuplicateUser(user); //이메일 중복 검증
        userMapper.save(user);
        return userMapper.findByEmail(user.getEmail());
    }

    private void validateDuplicateUser(User user) {
        Optional<User> optionalUser = userMapper.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }

    public Optional<User> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

}
