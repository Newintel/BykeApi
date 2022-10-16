package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.EntitySortie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortieEntityRepository extends JpaRepository<EntitySortie, Integer> {
}