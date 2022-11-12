package jcw.camoServer.controller;

import jcw.camoServer.dto.LoginDto;
import jcw.camoServer.entity.Member;
import jcw.camoServer.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto) {

    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginDto loginDto, BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL) {
        if (bindingResult.hasErrors()) {
            return null;
        }

        Member loginMember = loginService.login(loginDto.getEmail(), loginDto.getPassword());

        if (loginMember == null) {
            bindingResult.reject("login fail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "null";
        }

        return "redirect:" + redirectURL;
    }
}
