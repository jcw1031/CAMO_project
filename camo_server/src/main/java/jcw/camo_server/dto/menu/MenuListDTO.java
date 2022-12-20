package jcw.camo_server.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuListDTO {
    private Long menuId;
    private String menuName;
    private int menuPrice;
}
