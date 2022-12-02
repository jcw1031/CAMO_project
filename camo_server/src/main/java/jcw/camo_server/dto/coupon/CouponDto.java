package jcw.camo_server.dto.coupon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CouponDto {
    private int stampQuantity;
    private Long userId;
    private String cafeId;

    @Builder
    public CouponDto(int stampQuantity, Long userId, String cafeId) {
        this.stampQuantity = stampQuantity;
        this.userId = userId;
        this.cafeId = cafeId;
    }
}
