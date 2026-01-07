package com.example.demo.services;

import com.example.demo.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public boolean deleteReviewById(Long id);

    List<Review> findAllReview();
}
