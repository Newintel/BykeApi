package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Excursion;
import com.webservices.bykeapi.domain.ExcursionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public interface ExcursionRepository extends JpaRepository<Excursion, ExcursionId> {
    @Query("SELECT e FROM Excursion e WHERE e.id2 = ?1")
    Excursion findId(int id);

    @Modifying
    @Transactional
    @Query("update Excursion e set e.id.departure = ?2 where e.id2 = ?1")
    void updateDeparture(int id, Instant newDeparture);
}