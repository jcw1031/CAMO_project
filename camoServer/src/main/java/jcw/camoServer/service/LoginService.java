package jcw.camoServer.service;

import jcw.camoServer.entity.User;
import jcw.camoServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
