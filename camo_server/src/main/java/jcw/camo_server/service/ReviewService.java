package jcw.camo_server.service;

import jcw.camo_server.dto.review.CafeReviewListDTO;
import jcw.camo_server.dto.review.UserReviewListDTO;
import jcw.camo_server.entity.Review;
import jcw.camo_server.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public void write(final Review review) {
        review.setReviewDate();
        log.info("review write = {}", review);
        reviewMapper.reviewSave(review);
    }

    public List<CafeReviewListDTO> findByCafeId(final String cafeId) {
        return reviewMapper.findByCafeId(cafeId);
    }

    public List<UserReviewListDTO> findByUserId(final Long userId) {
        return reviewMapper.findByUserId(userId);
    }

    public List<Review> findAll() {
        return reviewMapper.findAll();
    }

    public void deleteReview(Long reviewId) {
        Optional<Review> optionalReview = reviewMapper.findByReviewId(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            reviewMapper.reviewDelete(review);
        } else {
            throw new IllegalArgumentException("이미 삭제된 리뷰");
        }
    }
}
