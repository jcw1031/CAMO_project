package jcw.camo_server.controller;

import jcw.camo_server.dto.MenuListDto;
import jcw.camo_server.entity.Menu;
import jcw.camo_server.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    /**
     * menu 등록
     */
    @PostMapping("/register")
    public void menuRegister(@RequestBody Menu menu) {
        log.info("menu = {}", menu);
        menuService.register(menu);
    }

    /**
     * cafe별 menu 리스트 조회
     */
    @GetMapping("/{cafeId}")
    public List<MenuListDto> menuListByCafe(@PathVariable("cafeId") String cafeId) {
        return menuService.findByCafeId(cafeId);
    }

    /**
     * menu 정보 수정
     */
    @PutMapping("/update")
    public void updateMenu(@RequestBody Menu menu) {
        menuService.menuUpdate(menu);
    }

    /**
     * menu 삭제
     */
    @DeleteMapping("/{menuId}")
    public void deleteMenu(@PathVariable("menuId") Long menuId) {
        menuService.menuDelete(menuId);
    }
}
