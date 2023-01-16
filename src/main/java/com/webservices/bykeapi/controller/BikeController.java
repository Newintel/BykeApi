package com.webservices.bykeapi.controller;


import com.webservices.bykeapi.domain.Bike;
import com.webservices.bykeapi.service.BikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Object>> getBikes(@PathVariable("id") int id) {
        return ResponseEntity.ok(bikeService.getUserBikes(id));
//        return bikeService.getUserBikes(id);
    }
}
