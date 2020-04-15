package com.thoughtwork.pro.Services;

import com.thoughtwork.pro.Entity.Reviews;
import com.thoughtwork.pro.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Reviews> findReviewsById(@RequestParam(name = "movie_id") int movie_id) {
        return reviewRepository.selectReviewsById(movie_id);
    }

}
