package com.example.demo.Repositories;

import com.example.demo.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicense(Long id, String license);

    @Query(nativeQuery = true, value = "SELECT * FROM Driver Where id= :id AND license= :license") // Raw sql query , error is thrown at the runtime
    Optional<Driver> rawfindByIdAndLicense(@Param("id") Long id, @Param("license") String license);

    // Optional<Driver> findById(Long id);

    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.license = :license") // hibernate query error is given at compiled time
    Optional<Driver> hqlFindByIdAndLicense(
            @Param("id") Long id,
            @Param("license") String license
    );
}
