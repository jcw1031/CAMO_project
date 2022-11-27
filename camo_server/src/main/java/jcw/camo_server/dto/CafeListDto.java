package jcw.camo_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CafeListDto {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private Double avgRating;
}
