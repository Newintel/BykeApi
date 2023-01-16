package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.service.PathService;
import com.webservices.bykeapi.domain.Path;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/paths")
public class PathController {
    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping("")
    public List<Path> getPaths() {
        return pathService.getAll();
    }

    @GetMapping("/mostPopular")
    public List<Path> getMostPopular() {
        return pathService.getMostPopular();
    }

    @GetMapping("/{id}")
    public Path getPathById(@PathVariable("id") int id) {
        return pathService.getById(id);
    }

    @GetMapping("/user/{id}")
    public List<Path> getPathsByUserId(@PathVariable("id") int id) {
        return pathService.getByUserId(id);
    }

    @PostMapping("")
    public Path addPath(@RequestBody Path path) {
        return pathService.create(path);
    }

    @PutMapping("/{id}")
    public void updatePath(@RequestBody Path sortie, @PathVariable("id") int id) {
        pathService.update(id, sortie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        pathService.delete(id);
    }
}
