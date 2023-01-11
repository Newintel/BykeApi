package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Excursion;
import com.webservices.bykeapi.domain.ExcursionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepository extends JpaRepository<Excursion, ExcursionId> {
}