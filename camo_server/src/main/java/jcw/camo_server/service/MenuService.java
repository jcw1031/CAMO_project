package jcw.camo_server.service;

import jcw.camo_server.dto.MenuListDto;
import jcw.camo_server.entity.Menu;
import jcw.camo_server.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public void register(Menu menu) {
        menuMapper.menuSave(menu);
    }

    public List<MenuListDto> findByCafeId(String cafeId) {
        return menuMapper.findByCafeId(cafeId);
    }

    public void menuUpdate(Menu menu) {
        menuUpdate(menu);
    }

    public void menuDelete(Long menuId) {
        menuMapper.menuDelete(menuId);
    }
}