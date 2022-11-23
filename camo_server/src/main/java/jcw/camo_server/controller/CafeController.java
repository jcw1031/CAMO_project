package jcw.camo_server.controller;

import jcw.camo_server.dto.CafeListDto;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.service.CafeService;
import jcw.camo_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;
    private final UserService userService;

    /**
     * cafe 등록
     *
     * @param cafe 등록할 Cafe
     * @return 등록된 Cafe
     */
    @PostMapping("/register")
    public Cafe cafeRegister(@RequestBody Cafe cafe) {
        return cafeRegister(cafe);
    }

    /**
     * Cafe 리스트 조회
     *
     * @return 모든 Cafe 리스트
     */
    @GetMapping("/list")
    public List<CafeListDto> cafeList() {
        return cafeService.cafeList();
    }

    /**
     * Cafe 이름으로 검색
     *
     * @param name 검색어
     * @return 검색어가 이름에 포함된 Cafe 리스트
     */
    @GetMapping("/name/{name}")
    public List<CafeListDto> searchCafeByName(@PathVariable("name") String name) {
        System.out.println(name);
        return cafeService.findByName(name);
    }
}
