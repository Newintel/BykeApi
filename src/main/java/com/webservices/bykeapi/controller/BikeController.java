package com.webservices.bykeapi.controller;


import com.webservices.bykeapi.domain.Bike;
import com.webservices.bykeapi.repository.BikeFull;
import com.webservices.bykeapi.service.BikeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/bikes")
public class BikeController {
    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @RequestMapping("/{id}")
    public List<BikeFull> getBikes(@PathVariable("id") int id) {
        return bikeService.getUserBikes(id);
    }
}
