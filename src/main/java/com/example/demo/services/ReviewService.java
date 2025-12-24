package com.example.demo.services;

import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@EnableJpaAuditing
public class ReviewService implements CommandLineRunner {

    ReviewRepository reviewRepo;

    public ReviewService(ReviewRepository reviewRepository){ // constructor dependency injection
        this.reviewRepo= reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************");
        Review r= Review.builder().content("Amazing ride exp")
                .ratings(4.6).build();

        reviewRepo.save(r); // this code executes sql queries

        List<Review> reviews= reviewRepo.findAll();

        for(Review review: reviews){
            System.out.println(review.getContent());
        }

        reviewRepo.deleteAllById(List.of(2L));
    }
}
