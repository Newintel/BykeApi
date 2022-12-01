package com.webservices.bykeapi.service;

import com.webservices.bykeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    // on initialise
    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    com.webservices.bykeapi.domain.User user = null;
    // on accède à l'utilisateur
    user = userRepository.findByUsername(username);
    if (user != null) {
        return new User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    } else {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
}