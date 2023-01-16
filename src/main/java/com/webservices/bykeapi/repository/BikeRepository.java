package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.webservices.bykeapi.domain.Bike;

public interface BikeRepository extends JpaRepository<Path, Integer> {
    @Query("select Bike from Bike join Purchase where Purchase.user = :userId")
    List<Bike> getUserBikes(int userId);
}