package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassenderReview extends Review{
    private String passengerReviewComment;
}
