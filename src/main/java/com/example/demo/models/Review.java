package com.example.demo.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingReview")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String content;

    Double ratings;

    @Column(nullable = false)
    @Timestamp
    @CreatedDate // this annotations tells spring to handle object creation only
    Date createdAt;

    @Column(nullable = false)
    @Timestamp
    @LastModifiedDate  // this annotations tells spring to handle object update
    Date updatedAt;


}
