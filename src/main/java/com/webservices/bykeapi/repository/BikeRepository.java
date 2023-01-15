package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BikeRepository extends JpaRepository<Path, Integer> {
    @Query("select Bike.id, Bike.brand, Bike.cassette, Bike.wheels, 'purchaseDate', 'type', User.id, User.username from Bike join Purchase where Purchase.user = :userId")
    List<BikeFull> getUserBikes(int userId);
}