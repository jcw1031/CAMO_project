package jcw.camo_server.service;

import jcw.camo_server.dto.menu.MenuListDTO;
import jcw.camo_server.entity.Menu;
import jcw.camo_server.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public void register(final Menu menu) {
        menuMapper.menuSave(menu);
    }

    public List<MenuListDTO> findByCafeId(final String cafeId) {
        return menuMapper.findByCafeId(cafeId);
    }

    public void menuUpdate(final Menu menu) {
        menuUpdate(menu);
    }

    public void menuDelete(final Long menuId) {
        menuMapper.menuDelete(menuId);
    }
}