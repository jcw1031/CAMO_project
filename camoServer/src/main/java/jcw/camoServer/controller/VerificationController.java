package jcw.camoServer.controller;

import jcw.camoServer.service.CafeService;
import jcw.camoServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationController {
    @Autowired
    UserService userService;
    @Autowired
    CafeService cafeService;

}
