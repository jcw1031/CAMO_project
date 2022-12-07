package jcw.camo_server.mapper;

import jcw.camo_server.dto.menu.MenuListDTO;
import jcw.camo_server.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MenuMapper {

    /**
     * menu 저장
     */
    void menuSave(Menu menu);

    /**
     * 카페별 메뉴 리스트
     */
    List<MenuListDTO> findByCafeId(String cafeId);

    Optional<Menu> findMenu(@Param("cafeId") String cafeId, @Param("menuName") String menuName);

    void menuUpdate(Menu menu);

    /**
     * menu 삭제
     */
    void menuDelete(Long menuId);
}
