package jcw.camoServer.service;

import jcw.camoServer.entity.User;
import jcw.camoServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    @Autowired
    MemberRepository memberRepository;

    public User login(String email, String password) {
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
