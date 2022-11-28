package jcw.camo_server.mapper;

import jcw.camo_server.dto.MenuListDto;
import jcw.camo_server.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    /**
     * menu 저장
     */
    void menuSave(Menu menu);

    /**
     * 카페별 메뉴 리스트
     */
    List<MenuListDto> findByCafeId(String cafeId);

    void menuUpdate(Menu menu);

    /**
     * menu 삭제
     */
    void menuDelete(Long menuId);
}
