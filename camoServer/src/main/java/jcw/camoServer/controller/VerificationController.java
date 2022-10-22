package jcw.camoServer.controller;

import jcw.camoServer.service.CafeService;
import jcw.camoServer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationController {
    @Autowired
    MemberService memberService;
    @Autowired
    CafeService cafeService;

}
