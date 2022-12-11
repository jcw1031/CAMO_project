package jcw.camo_server.dto.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserReviewListDTO {
    private Long reviewId;
    private int reviewRating;
    private String reviewContent;
    private String reviewDate;
    private String cafeName;

    @Builder
    public UserReviewListDTO(Long reviewId, int reviewRating, String reviewContent, String reviewDate
            , String cafeName) {
        this.reviewId = reviewId;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.cafeName = cafeName;
    }
}
