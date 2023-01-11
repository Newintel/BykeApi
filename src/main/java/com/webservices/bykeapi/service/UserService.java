package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.User;
import com.webservices.bykeapi.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) throws IllegalArgumentException {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid user Id:" + id)
        );
    }

    public User getByUsername(String username) throws IllegalArgumentException {
        return userRepository.findByUsername(username);
    }

    public User create(User user) throws IllegalArgumentException {
        User _user = new User();
        _user.setUsername(user.getUsername());
        if (userRepository.exists(Example.of(_user))) {
            throw new IllegalArgumentException("User already exists");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
