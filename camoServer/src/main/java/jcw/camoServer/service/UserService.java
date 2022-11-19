package jcw.camoServer.service;

import jcw.camoServer.entity.User;
import jcw.camoServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User join(User user){
        validateDuplicateMember(user);

        return userRepository.save(user);
    }

    private void validateDuplicateMember(User user) {
        userRepository.findByEmail(user.getEmail()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 이메일입니다.");
                });
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(long id){
        Optional<User> member = userRepository.findById(id);
        if (member.isPresent()) {
            return member;
        }
        System.out.println("존재하지 않습니다.");
        return null;
    }

    public Optional<User> findByEmail(String email){
        Optional<User> member = userRepository.findByEmail(email);
        if (member.isPresent()) {
            return member;
        }
        System.out.println("존재하지 않습니다.");
        return null;
    }

    public void delete(User memeber) {
        userRepository.delete(memeber);
    }
}
