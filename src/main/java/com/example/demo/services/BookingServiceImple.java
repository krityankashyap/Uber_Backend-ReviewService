package com.example.demo.services;

import com.example.demo.Repositories.BookingRepository;
import com.example.demo.models.Booking;

import java.util.List;
import java.util.Optional;

public class BookingServiceImple implements BookingService{

    BookingRepository bookingRepo;

    public BookingServiceImple(BookingRepository bookingRepository){
        this.bookingRepo= bookingRepository;
    }

    @Override
    public List<Booking> findBookingByDriverId(Long id){
        return bookingRepo.findAllById(id);
    }
    
    @Override
    public Boolean deleteBookingById(Long id){
         try{
             bookingRepo.deleteById(id);
             return true;
         } catch (Exception e) {
             return false;
         }
    }
}
