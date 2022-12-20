package jcw.camo_server.dto.coupon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CouponListDTO {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafeReward;
    private int cafeRewardstamp;
    private int couponUserstamp;

    @Builder
    public CouponListDTO(String cafeId, String cafeName, String cafeAddress, String cafeReward, int cafeRewardstamp, int couponUserstamp) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafeReward = cafeReward;
        this.cafeRewardstamp = cafeRewardstamp;
        this.couponUserstamp = couponUserstamp;
    }
}
