package jcw.camo_server.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class Cafe {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduce;
    private String cafeReward;
    private int cafeRewardstamp;
    private String cafeImage;
    private Long userId;


    @Builder
    public Cafe(String cafeId, String cafeName, String cafeAddress, String cafePhone, String cafeIntroduce
            , String cafeReward, int cafeRewardstamp, String cafeImage, Long userId) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafePhone = cafePhone;
        this.cafeIntroduce = cafeIntroduce;
        this.cafeReward = cafeReward;
        this.cafeRewardstamp = cafeRewardstamp;
        this.cafeImage = cafeImage;
        this.userId = userId;
    }
}
