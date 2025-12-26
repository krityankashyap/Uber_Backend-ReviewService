package com.example.demo.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseClass{

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    private Review driverReview; // We have defined 1:1 relationship between review and booking

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingstatus;

    @Timestamp
    private Date startTime;

    private Date Endtime;

    private long totalDistance;
}
