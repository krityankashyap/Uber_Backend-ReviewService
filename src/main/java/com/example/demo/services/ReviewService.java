package com.example.demo.services;

import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.DriverRepository;
import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.models.Booking;
import com.example.demo.models.Driver;
import com.example.demo.models.Review;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;

@Service
@EnableJpaAuditing

public class ReviewService implements CommandLineRunner {

    ReviewRepository reviewRepo;
    BookingRepository bookingRepo;
    DriverRepository  driverRepo;

    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository , DriverRepository driverRepository){ // constructor dependency injection
        this.reviewRepo= reviewRepository;
        this.bookingRepo= bookingRepository;
        this.driverRepo= driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("***************");
//        Review r= Review.builder().content("Amazing ride exp")
//                .ratings(4.6).build();
//
//        Booking b= Booking.builder()
//                          .driverReview(r)
//                          .Endtime(new Date())
//                          .build();
//
//        // reviewRepo.save(r); // this code executes sql queries
//        bookingRepo.save(b);
//
//
//        List<Review> reviews= reviewRepo.findAll();
//
//        for(Review review: reviews){
//            System.out.println(review.getContent());
//        }
//
//        reviewRepo.deleteAllById(List.of(2L));

//        Optional<Driver> driver= driverRepo.findByIdAndLicenseNumber(1L, "DL1212");
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//            List<Booking> bookings= bookingRepo.findAllByDriverId(1L);
//            for(Booking booking: bookings){
//                System.out.println(booking.getBookingstatus());
//
//            }
//       }

//        Optional<Driver> driver = driverRepo.findById(1L);
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//
//            List<Booking> b= driver.get().getBookings();
//
//            for(Booking booking: b){
//                System.out.println(booking.getId());
//            }
//           List<Booking> bookings= bookingRepo.findAllByDriverId(1L);
//           for(Booking booking: bookings){
//               System.out.println(booking.getBooking status());
//           }
//        }
//        Optional<Driver> driver= driverRepo.findByIdAndLicense(2L, "DL232323");
//        System.out.println(driver.get().getName());
//

        List<Long> driverIds= new ArrayList<>(Arrays.asList(1L , 2L));

        List<Driver> drivers= driverRepo.findAllByIdIn(driverIds);

    //    List<Booking> bookings= bookingRepo.findAllByDriverIn(drivers);  custom implementation for N+1 query

        for(Driver driver: drivers){
            List<Booking> bookings= driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
