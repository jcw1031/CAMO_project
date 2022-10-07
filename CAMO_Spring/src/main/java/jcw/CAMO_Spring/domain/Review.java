package jcw.CAMO_Spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Review {
    private Long reviewId; //리뷰번호(PK)
    private Long memberId; //회원번호(FK)
    private Long cafeId; //카페번호(FK)
    private double starRating; //별점
    private String description; //리뷰 본문
    private Date date; //작성날짜
}
