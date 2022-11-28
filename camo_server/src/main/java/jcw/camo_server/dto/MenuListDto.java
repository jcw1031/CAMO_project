package jcw.camo_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class MenuListDto {
    private String menuName;
    private int menuPrice;
}
