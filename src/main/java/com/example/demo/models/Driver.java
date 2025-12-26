package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseClass {

    private String name;

    @Column(nullable = false , unique = true)
    private String license;

    // Driver has many bookings and each booking belongs to a driver(1:n)
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings= new ArrayList<>();
}
