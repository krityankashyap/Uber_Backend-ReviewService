package com.example.demo.services;

import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.models.Review;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImple implements ReviewService{

    private ReviewRepository reviewRepo;

    public ReviewServiceImple(ReviewRepository reviewRepository){
        this.reviewRepo= reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) throws EntityNotFoundException {
        Optional<Review> review;
        try{
            review= this.reviewRepo.findById(id);
            if(review.isEmpty()){
                throw new EntityNotFoundException("Review with id "+ id + "not found");
            }
        } catch (Exception e) {
            throw new FetchNotFoundException("Unable to fetch, Please try again later ", id);
        }
        return review;
    }

    @Override
    public List<Review> findAllReview(){
        return this.reviewRepo.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id){
        try{
            this.reviewRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Review publishReview(Review review){
        return this.reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReview){
        Review reviews= this.reviewRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        if(newReview.getRatings()!= null){
            reviews.setRatings(newReview.getRatings());
        }

        if(newReview.getContent()!= null){
            reviews.setContent(newReview.getContent());
        }
        return this.reviewRepo.save(reviews);
    }
}
