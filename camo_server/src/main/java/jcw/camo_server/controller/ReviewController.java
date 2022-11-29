package jcw.camo_server.controller;

import jcw.camo_server.entity.Review;
import jcw.camo_server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    public List<Review> reviewList() {
        return reviewService.findAll();
    }
}
