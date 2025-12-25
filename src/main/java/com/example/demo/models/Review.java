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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Review extends BaseClass {



    @Column(nullable = false)
    private String content;

    private Double ratings;


}
