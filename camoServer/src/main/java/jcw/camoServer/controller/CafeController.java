package jcw.camoServer.controller;

import jcw.camoServer.entity.Cafe;
import jcw.camoServer.service.CafeService;
import jcw.camoServer.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/cafe")
public class CafeController {

    @Autowired
    CafeService cafeService;
    @Autowired
    MemberService memberService;

    /**
     * 카페 등록
     */
    @PostMapping("register")
    public void cafeRegister(@ModelAttribute Cafe cafe) {
        log.info("cafe = {}", cafe);
        Cafe register = cafeService.register(cafe);
        log.info("cafe = {}", register);
        System.out.println(cafe == register);
    }

    /**
     * 카페 리스트
     */
    @GetMapping("search/all")
    public List<Cafe> cafeList() {
        return cafeService.findAll();
    }

    /**
     * id를 통한 카페 검색
     */
    @GetMapping("search/id/{id}")
    public Optional<Cafe> cafeSearchById(@PathVariable("id") long id) {
        Optional<Cafe> cafe = cafeService.findById(id);
        if (cafe.isPresent()) {
            return cafe;
        }
        else{
            System.out.println("검색 결과 없음");
            return Optional.empty();
        }
    }

    /**
     * 카페 이름으로 검색
     */
    @GetMapping("search/name/{name}")
    public List<Cafe> cafeSearchByName(@PathVariable("name") String name) {
        return cafeService.findByName(name);
    }
}
