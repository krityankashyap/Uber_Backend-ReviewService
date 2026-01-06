package com.example.demo.Repositories;

import com.example.demo.models.Booking;
import com.example.demo.models.Driver;
import com.example.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllById(Long driverId);

    List<Booking> findAllByDriverIn(List<Driver> drivers);


}
