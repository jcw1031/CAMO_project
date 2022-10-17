package jcw.CAMO_Server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cafeId;

    private int memberId;
    private String cafeName;
    private String cafeAddress;
    private String cafeCallNumber;
    private int stampsNumber;
    private String couponReward;
    private String cafeIntroduce;
}
