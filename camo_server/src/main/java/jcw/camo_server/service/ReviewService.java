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

    public List<Review> findAll() {
        return reviewMapper.findAll();
    }
}
