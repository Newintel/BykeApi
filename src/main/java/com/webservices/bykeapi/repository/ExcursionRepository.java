package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Excursion;
import com.webservices.bykeapi.domain.ExcursionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExcursionRepository extends JpaRepository<Excursion, ExcursionId> {
    @Query("SELECT e FROM Excursion e WHERE e.id2 = ?1")
    Excursion findId(int id);
}