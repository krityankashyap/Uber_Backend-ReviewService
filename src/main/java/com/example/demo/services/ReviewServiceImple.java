package com.example.demo.services;

import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.models.Review;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImple implements ReviewService{

    private ReviewRepository reviewRepo;

    public ReviewServiceImple(ReviewRepository reviewRepository){
        this.reviewRepo= reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepo.findById(id);
    }

    @Override
    public List<Review> findAllReview(){
        return reviewRepo.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id){
        try{
            reviewRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
