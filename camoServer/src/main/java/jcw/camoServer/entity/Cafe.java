package jcw.camoServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Cafe {
    @Id
    private Long cafeId;

    private Long memberId;
    private String cafeName;
    private String cafeAddress;
    private String cafeCallNumber;
    private int stampsNumber;
    private String couponReward;
    private String cafeIntroduce;
}
