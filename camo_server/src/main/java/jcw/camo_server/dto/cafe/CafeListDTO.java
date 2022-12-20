package jcw.camo_server.dto.cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CafeListDTO {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private Double avgRating;
}
