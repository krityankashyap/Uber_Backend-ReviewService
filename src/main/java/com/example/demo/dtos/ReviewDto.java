package com.example.demo.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class ReviewDto {
    private Long id;
    private String content;
    private Double rating;
    private Long booking;
    private LocalDateTime createdAt;
    private LocalDate updatedAt;
}
