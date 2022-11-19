package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortieRepository extends JpaRepository<Sortie, Integer> {
}