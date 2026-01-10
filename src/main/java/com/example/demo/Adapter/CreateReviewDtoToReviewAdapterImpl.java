package com.example.demo.Adapter;

import com.example.demo.Repositories.BookingRepository;
import com.example.demo.dtos.CreateReviewDto;
import com.example.demo.models.Booking;
import com.example.demo.models.Review;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;


    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
        this.bookingRepository= bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking>booking= this.bookingRepository.findById(createReviewDto.getBooking_id());
        if(booking.isEmpty()){
            return null;
        }
        Review review= Review.builder()
                .ratings(createReviewDto.getRatings())
                .content(createReviewDto.getContent())
                .booking(booking.get())
                .build();

        return review;
    }
}
