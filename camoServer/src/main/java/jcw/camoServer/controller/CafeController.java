package jcw.camoServer.controller;

import jcw.camoServer.entity.Cafe;
import jcw.camoServer.entity.User;
import jcw.camoServer.service.CafeService;
import jcw.camoServer.service.UserService;
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
    UserService userService;

    /**
     * 카페 등록
     */
    @PostMapping("/register")
    public User cafeRegister(@RequestBody Cafe cafe) {
        Optional<User> user = userService.findById(cafe.getUserId());
        if(user.isPresent()) {
            Cafe register = cafeService.register(cafe);
            userService.userRoleChange(user.get());
            log.info("cafe = {}", register);
            System.out.println(cafe == register);
            return user.get();
        }
        else{
            log.info("사업자 번호 없음!");
            return null;
        }
    }

    /**
     * 카페 리스트
     */
    @GetMapping("/list")
    public List<Cafe> cafeList() {
        return cafeService.findAll();
    }

    /**
     * id를 통한 카페 검색
     */
    @GetMapping("/id/{id}")
    public Optional<Cafe> cafeSearchById(@PathVariable("id") String id) {
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
    @GetMapping("/name/{name}")
    public List<Cafe> cafeSearchByName(@PathVariable("name") String name) {
        List<Cafe> list = cafeService.findByName(name);
        log.info("list = {}", list);
        return list;
    }
}
