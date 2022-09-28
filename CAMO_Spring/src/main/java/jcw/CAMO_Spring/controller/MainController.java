package jcw.CAMO_Spring.controller;

import jcw.CAMO_Spring.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private MemberService memberService;

    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }
}
