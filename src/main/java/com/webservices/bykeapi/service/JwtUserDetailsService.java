package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Utilisateur;
import com.webservices.bykeapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UtilisateurRepository unUtilisateurRepostory;

    // on initialise
    @Autowired
    public JwtUserDetailsService(UtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utilisateur unUtilisateur = null;
    // on accède à l'utilisateur
    unUtilisateur = unUtilisateurRepostory.recherchePseudo(username);
    if (unUtilisateur != null) {
        return new User(unUtilisateur.getNomUtil(), unUtilisateur.getMdpUtil(),
                new ArrayList<>());
    } else {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
}