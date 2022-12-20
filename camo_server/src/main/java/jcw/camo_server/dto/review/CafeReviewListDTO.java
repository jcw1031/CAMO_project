package jcw.camo_server.dto.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CafeReviewListDTO {
    private Long reviewId;
    private String userEmail;
    private int reviewRating;
    private String reviewContent;
    private String reviewDate;
    private String cafeId;

    @Builder
    public CafeReviewListDTO(Long reviewId, String userEmail, int reviewRating, String reviewContent, String reviewDate, String cafeId) {
        this.reviewId = reviewId;
        this.userEmail = userEmail;
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.cafeId = cafeId;
    }
}
