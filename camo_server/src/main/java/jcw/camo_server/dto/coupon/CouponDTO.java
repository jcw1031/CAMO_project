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
    private String userEmail;
    private String cafeId;

    @Builder
    public CouponDTO(int stampQuantity, String userEmail, String cafeId) {
        this.stampQuantity = stampQuantity;
        this.userEmail = userEmail;
        this.cafeId = cafeId;
    }
}
