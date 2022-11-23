package jcw.camo_server.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CafeListDto {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private Double avgRating;
}
