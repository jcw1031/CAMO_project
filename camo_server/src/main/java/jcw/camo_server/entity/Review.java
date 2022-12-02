package jcw.camo_server.entity;

import lombok.*;

import java.sql.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    private Long reviewId;
    private String userEmail;
    private int reviewRating;
    private String reviewContent;
    private Date reviewDate;
    private Long userId;
    private String cafeId;
}
