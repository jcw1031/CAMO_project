package jcw.camo_server.dto.cafe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CafeInfoDTO {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduce;
    private String cafeReward;
    private int cafeRewardstamp;
    private String cafeImage;
    private Double avgRating;
    private int couponUserstamp;

    @Builder
    public CafeInfoDTO(String cafeId, String cafeName, String cafeAddress, String cafePhone
            , String cafeIntroduce, String cafeReward, int cafeRewardstamp, String cafeImage
            , Double avgRating, int couponUserstamp) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafePhone = cafePhone;
        this.cafeIntroduce = cafeIntroduce;
        this.cafeReward = cafeReward;
        this.cafeRewardstamp = cafeRewardstamp;
        this.cafeImage = cafeImage;
        this.avgRating = avgRating;
        this.couponUserstamp = couponUserstamp;
    }
}
