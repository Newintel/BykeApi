package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PathRepository extends JpaRepository<Path, Integer> {
    @Query("select p from Path p inner join Excursion e on p.id = e.path.id group by p.id order by count(e.id.departure) desc")
    List<Path> getMostPopular();


}