package com.example.demo.Repositories;

import com.example.demo.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicense(Long id, String license);

    List<Driver> findAllByIdIn(List<Long> driverIds);


}
