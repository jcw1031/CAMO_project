package jcw.camo_server.controller;

import jcw.camo_server.dto.menu.MenuListDTO;
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
    @PostMapping("")
    public void menuRegister(@RequestBody final Menu menu) {
        log.info("menu = {}", menu);
        menuService.register(menu);
    }

    /**
     * cafe별 menu 리스트 조회
     */
    @GetMapping("/{cafeId}")
    public List<MenuListDTO> menuListByCafe(@PathVariable("cafeId") final String cafeId) {
        return menuService.findByCafeId(cafeId);
    }

    /**
     * menu 정보 수정
     */
    /*@PutMapping("/update")
    public void updateMenu(@RequestBody final Menu menu) {
        menuService.menuUpdate(menu);
    }*/

    /**
     * menu 삭제
     */
    @DeleteMapping("/{menuId}")
    public void deleteMenu(@PathVariable("menuId") final Long menuId) {
        menuService.menuDelete(menuId);
    }
}
