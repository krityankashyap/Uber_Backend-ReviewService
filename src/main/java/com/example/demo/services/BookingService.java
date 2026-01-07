package com.example.demo.services;

import com.example.demo.models.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    public List<Booking> findBookingByDriverId(Long id);

    public Boolean deleteBookingById(Long id);

  //  public Optional<Booking> getBookingById(Long id);
}
