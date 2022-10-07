package jcw.CAMO_Spring.service;

import jcw.CAMO_Spring.domain.Review;
import jcw.CAMO_Spring.repository.ReviewRepository;

public class ReviewService {
    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

   /* public Long write(Review review){

    }*/

}
