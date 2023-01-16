package com.webservices.bykeapi.service;

import com.webservices.bykeapi.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.webservices.bykeapi.domain.Bike;


@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<BikeResponse> getUserBikes(int id) {
        List<Bike> bikes = bikeRepository.getUserBikes(id);
        List<BikeResponse> res = new LinkedList<>();
        for (Bike bike : bikes) {
            BikeResponse item = new BikeResponse();
            item.id = bike.getId();
            item.brand = bike.getBrand();
            item.cassette = bike.getCassette();
            item.wheels = bike.getWheels();

            item.purchaseDate = "?";
            item.type = "?";

            item.owner = new Owner();
            item.owner.id = id;
            item.owner.name = "?";

            res.add(item);
        }
        return res;
    }
}

class BikeResponse {
    public int id;
    public String brand;
    public String cassette;
    public BigDecimal wheels;

    public String purchaseDate;
    public String type;
    public Owner owner;

    public BikeResponse() {}
}

class Owner {
    public int id;
    public String name;

    public Owner() {}
}