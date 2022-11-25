package jcw.camo_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Cafe {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduce;
    private String cafeReward;
    private int cafeRewardstamp;
    private Long userId;

    @Builder
    public Cafe(String cafeId, Long userId, String cafeName, String cafeAddress, String cafePhone
            , String cafeIntroduce, String cafeReward, int cafeRewardstamp) {
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
