package jcw.camo_server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    private Long couponId;
    private int couponUserstamp;
    private Long userId;
    private String cafeId;
}
