package jcw.camo_server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CafeUpdateDto {
    private String cafeId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduce;
    private String cafeReward;
    private int cafeRewardstamp;
}
