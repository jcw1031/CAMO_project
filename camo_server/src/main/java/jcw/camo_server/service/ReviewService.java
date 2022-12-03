package jcw.camo_server.service;

import jcw.camo_server.entity.Review;
import jcw.camo_server.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public Review write(final Review review) {
        return reviewMapper.reviewSave(review);
    }

    public List<Review> findByCafeId(final String cafeId) {
        return reviewMapper.findByCafeId(cafeId);
    }

    public List<Review> findByUserId(final Long userId) {
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
