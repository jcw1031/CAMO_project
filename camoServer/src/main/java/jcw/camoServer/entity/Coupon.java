package jcw.camoServer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_number")
    private Long couponId;

    @Column(name = "user_number")
    private Long userId;
    @Column(name = "cafe_number")
    private Long cafeId;
    @Column(name = "coupon_userstamp")
    private int stampsNumber;
}
