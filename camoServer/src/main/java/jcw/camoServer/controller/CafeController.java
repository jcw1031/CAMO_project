package jcw.camoServer.controller;

import jcw.camoServer.entity.Cafe;
import jcw.camoServer.service.CafeService;
import jcw.camoServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CafeController {

    @Autowired
    CafeService cafeService;
    @Autowired
    MemberService memberService;

    /**
     * 카페 등록
     */
    @PostMapping("/cafe/register")
    public void cafeRegister(@ModelAttribute Cafe cafe) {
        log.info("cafe = {}", cafe);
        Cafe register = cafeService.register(cafe);
        log.info("cafe = {}", register);
        System.out.println(cafe == register);
    }

    @GetMapping("/cafe/list")
    public List<Cafe> cafeList(){
        return cafeService.findAll();
    }
}
