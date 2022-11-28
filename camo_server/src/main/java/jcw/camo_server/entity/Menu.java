package jcw.camo_server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Long menuId;
    private String cafeId;
    private String menuName;
    private int menuPrice;
}
