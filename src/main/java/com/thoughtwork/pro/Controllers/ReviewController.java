package com.thoughtwork.pro.Controllers;

import com.thoughtwork.pro.Entity.Reviews;
import com.thoughtwork.pro.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v2/movie")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("reviews")
    public List<Reviews> findReviewsById(@RequestParam(name = "movie_id") int movieId) {
        try {
            return reviewService.findReviewsById(movieId);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
       return null;
    }
}
