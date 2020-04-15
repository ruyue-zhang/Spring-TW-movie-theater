package com.thoughtwork.pro.Controllers;

import com.thoughtwork.pro.Entity.Reviews;
import com.thoughtwork.pro.Repositories.ReviewRepository;
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
    private ReviewRepository reviewRepository;

    @GetMapping("reviews")
    public List<Reviews> findReviewsById(@RequestParam(name = "movie_id") int movie_id) {
       return reviewRepository.selectReviewsById(movie_id);
    }
}
