package jcw.camo_server.service.validator;

import jcw.camo_server.dto.user.SignupDto;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserMapper userMapper;

    /**
     * 회원가입 시 이메일 중복 검증
     * @param signupDto
     * @return
     */
    public User checkEmailDuplicate(SignupDto signupDto) {
        if (userMapper.findByEmail(signupDto.getEmail()).isPresent()) {
            System.out.println("예외 : 이미 존재하는 이메일입니다!");
            return null;
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
}
