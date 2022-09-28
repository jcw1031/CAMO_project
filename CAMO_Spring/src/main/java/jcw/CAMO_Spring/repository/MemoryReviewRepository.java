package jcw.CAMO_Spring.repository;

import jcw.CAMO_Spring.domain.Review;

import java.util.HashMap;
import java.util.Map;

public class MemoryReviewRepository implements ReviewRepository {
    Long sequence = 10000L;
    Map<Long, Review> reviewMap = new HashMap<>();

    @Override
    public Review save(Review review) {
        review.setReviewId(sequence++);
        reviewMap.put(review.getReviewId(), review);
        return review;
    }
}
