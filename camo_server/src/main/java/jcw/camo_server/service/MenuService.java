package jcw.camo_server.service;

import jcw.camo_server.dto.menu.MenuListDTO;
import jcw.camo_server.entity.Menu;
import jcw.camo_server.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {

    private final MenuMapper menuMapper;

    @Transactional
    public void register(final Menu menu) {
        Optional<Menu> optionalMenu = menuMapper.findMenu(menu.getCafeId(), menu.getMenuName());
        if (optionalMenu.isPresent()) {
            Menu updateMenu = Menu.builder()
                    .menuId(optionalMenu.get().getMenuId())
                    .menuName(menu.getMenuName())
                    .menuPrice(menu.getMenuPrice())
                    .cafeId(optionalMenu.get().getCafeId())
                    .build();
            log.info("메뉴 수정 = {}", updateMenu);
            menuMapper.menuUpdate(updateMenu);
        } else {
            log.info("메뉴 등록 = {}", menu);
            menuMapper.menuSave(menu);
        }
    }

    public List<MenuListDTO> findByCafeId(final String cafeId) {
        return menuMapper.findByCafeId(cafeId);
    }

    /*public void menuUpdate(final Menu menu) {
        menuUpdate(menu);
    }*/

    public void menuDelete(final Long menuId) {
        menuMapper.menuDelete(menuId);
    }
}