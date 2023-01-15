package com.webservices.bykeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.webservices.bykeapi.service.PathService;
import com.webservices.bykeapi.domain.Path;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("")
    public ResponseEntity addPath(@RequestBody Path path) {
        Path _path = pathService.create(path);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("id", _path.getId());

        return ResponseEntity.ok().body(node);
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
