package com.webservices.bykeapi.service;

import com.webservices.bykeapi.repository.BikeFull;
import com.webservices.bykeapi.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<BikeFull> getUserBikes(int id) {
        return bikeRepository.getUserBikes(id);
    }
}
