package jcw.camo_server.dto.coupon;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CouponDTO {
    private int stampQuantity;
    private Long userId;
    private String cafeId;

    @Builder
    public CouponDTO(int stampQuantity, Long userId, String cafeId) {
        this.stampQuantity = stampQuantity;
        this.userId = userId;
        this.cafeId = cafeId;
    }
}
