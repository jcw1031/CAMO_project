package jcw.camo_server.controller;

import jcw.camo_server.entity.User;
import jcw.camo_server.exception.CustomException;
import jcw.camo_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        log.info("user = {}", user);
        Optional<User> joinUser = userService.join(user);
        log.info("user = {}", joinUser);
        return joinUser.get();
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@RequestParam("email") String email)  {
        System.out.println(email);
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
}
