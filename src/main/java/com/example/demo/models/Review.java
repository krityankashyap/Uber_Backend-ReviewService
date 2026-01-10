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

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)  // this annotations helps to modify the properties of the foreign key column that is present in another table
    private Booking booking;

    @Column(name = "rating")
    private Double ratings;



}
