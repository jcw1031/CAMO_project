package jcw.CAMO_Spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cafe {
    private Long cafeId; //카페번호(PK)
    private Long presidentId; //회원번호와 동일(FK)
    private String cafeName; //카페 이름
    private String address; //카페 주소
    private String callNumber; //전화번호
}
