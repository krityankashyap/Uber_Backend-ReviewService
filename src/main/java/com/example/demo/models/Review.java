package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id  // this annotation makes our id as primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
