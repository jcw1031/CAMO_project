package jcw.CAMO_Spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Coupon {
    private Long memberId; //회원번호(PK)(FK)
    private Long cafeId; //카페번호(PK)(FK)
    private int numberOfCoupons; //쿠폰 개수
    private String colorHexCode; //컬러코드(16진수)
}
