package jcw.camoServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Cafe {
    @Id
    private String cafeId;

    @Column(name = "user_number")
    private Long userId;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
//    @Column(name = "cafe_number")
//    private int stampsNumber;
    private String cafeReward;
    private String cafeIntroduce;
}
