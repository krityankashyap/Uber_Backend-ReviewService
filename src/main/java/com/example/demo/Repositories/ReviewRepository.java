package com.example.demo.Repositories;


import com.example.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingsIsLessThanEqual(Double givenRating);

    List<Review> findAllByRatingsIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);


    // Corrected JPQL (No 'ON' clause needed)
    @Query("SELECT b.review FROM Booking b WHERE b.id = :bookingId")
    Review findReviewByBookingId(@Param("bookingId") Long bookingId);

}