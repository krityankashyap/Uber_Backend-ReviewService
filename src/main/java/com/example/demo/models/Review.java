package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseClass {



    @Column(nullable = false)
    private String content;

    @OneToOne(cascade = {CascadeType.ALL})
    private Booking booking;

    @Column(name = "rating")
    private Double ratings;



}
