package jcw.camo_server.controller;

import jcw.camo_server.entity.Review;
import jcw.camo_server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * review 작성
     * @param review 작성할 review
     */
    @PostMapping("")
    public void writeReview(@RequestBody final Review review) {
        Review writtenReview = reviewService.write(review);
        log.info("review = {}", writtenReview);
    }

    /**
     * cafe별 review 리스트
     * @param cafeId review 리스트를 조회할 cafe의 cafeId
     * @return cafeId를 가진 cafe의 review 리스트
     */
    @GetMapping("/cafe/{id}")
    public List<Review> reviewListByCafe(@PathVariable("id") final String cafeId) {
        return reviewService.findByCafeId(cafeId);
    }

    /**
     * user별 review 리스트
     * @param userId review 리스트를 조회할 user의 userId
     * @return userId를 가진 user의 review 리스트
     */
    @GetMapping("/user/{id}")
    public List<Review> reviewListByUser(@PathVariable("id") final Long userId) {
        return reviewService.findByUserId(userId);
    }

    /**
     * 모든 review 리스트 조회
     * @return review 리스트
     */
    @GetMapping("/list")
    public List<Review> reviewList() {
        return reviewService.findAll();
    }

    /**
     * review 삭제
     * @param reviewId 삭제할 review의 reviewId
     */
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
