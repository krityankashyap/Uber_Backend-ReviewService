package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Passenger extends BaseClass {

    private String name;

    @OneToMany(mappedBy = "passenger")
    List<Booking> bookings= new ArrayList<>();
}
