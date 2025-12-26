package com.example.demo.services;

import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.models.Booking;
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
    BookingRepository bookingRepo;

    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository){ // constructor dependency injection
        this.reviewRepo= reviewRepository;
        this.bookingRepo= bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************");
        Review r= Review.builder().content("Amazing ride exp")
                .ratings(4.6).build();

        Booking b= Booking.builder()
                          .driverReview(r)
                          .Endtime(new Date())
                          .build();

        // reviewRepo.save(r); // this code executes sql queries
        bookingRepo.save(b);


        List<Review> reviews= reviewRepo.findAll();

        for(Review review: reviews){
            System.out.println(review.getContent());
        }

        reviewRepo.deleteAllById(List.of(2L));
    }
}
