package jcw.camo_server.service;

import jcw.camo_server.entity.Review;
import jcw.camo_server.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public Review write(Review review) {
        return reviewMapper.reviewSave(review);
    }

    public List<Review> findByCafeId(String cafeId) {
        return reviewMapper.findByCafeId(cafeId);
    }

    public List<Review> findByUserId(Long userId) {
        return reviewMapper.findByUserId(userId);
    }

    public List<Review> findAll() {
        return reviewMapper.findAll();
    }
}
