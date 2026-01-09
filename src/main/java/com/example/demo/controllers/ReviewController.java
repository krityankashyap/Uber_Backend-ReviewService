package com.example.demo.controllers;

import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public void RestController(ReviewService reviewService){
        this.reviewService= reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews= this.reviewService.findAllReview();

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }



}
