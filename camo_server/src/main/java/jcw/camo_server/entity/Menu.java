package jcw.camo_server.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class Menu {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String cafeId;

    @Builder
    public Menu(Long menuId, String menuName, int menuPrice, String cafeId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.cafeId = cafeId;
    }
}
