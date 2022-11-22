package com.webservices.bykeapi.repository;

import com.webservices.bykeapi.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur recherchePseudo(String nomUtil);
}