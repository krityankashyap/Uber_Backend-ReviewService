package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    // Change this line to map the Java field 'license' to the SQL column 'license_number'
    @Column(name = "license_number", nullable = false, unique = true)
    private String license;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings = new ArrayList<>();
}
