package com.example.demo.controllers;

import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{/reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(id);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (Exception e) {
              return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{/reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long id){
        try{
            boolean isDeleted= this.reviewService.deleteReviewById(id);
            if(!isDeleted) return new ResponseEntity<>("Unable to delete review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @PathVariable Review review){
        Review review1= this.reviewService.updateReview(reviewId, review);
        return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
    }

}
