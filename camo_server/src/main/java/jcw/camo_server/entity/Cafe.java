package jcw.camo_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cafe {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduce;
    private String cafeReward;
    private String cafeRewardstamp;
    private Long userId;

    @Builder
    public Cafe(String cafeId, Long userId, String cafeName, String cafeAddress, String cafePhone
            , String cafeIntroduce, String cafeReward, String cafeRewardstamp) {
        this.cafeId = cafeId;
        this.userId = userId;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafePhone = cafePhone;
        this.cafeIntroduce = cafeIntroduce;
        this.cafeReward = cafeReward;
        this.cafeRewardstamp = cafeRewardstamp;
    }
}
