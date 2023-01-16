package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Integer> {
}