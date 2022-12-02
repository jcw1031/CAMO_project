package jcw.camo_server.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class Coupon {
    private Long couponId;
    private int couponUserstamp;
    private Long userId;
    private String cafeId;

    @Builder
    public Coupon(Long couponId, int couponUserstamp, Long userId, String cafeId) {
        this.couponId = couponId;
        this.couponUserstamp = couponUserstamp;
        this.userId = userId;
        this.cafeId = cafeId;
    }
}
