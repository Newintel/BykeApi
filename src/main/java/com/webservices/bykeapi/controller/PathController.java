package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.domain.PathDto;
import com.webservices.bykeapi.service.PathService;
import com.webservices.bykeapi.domain.Path;
import com.webservices.bykeapi.service.StepService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/paths")
public class PathController {
    private final PathService pathService;

    public PathController(PathService pathService, StepService stepService) {
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
    public Path addPath(@RequestBody PathDto path) {
        return pathService.create(path);
    }

    @PutMapping("/{id}/steps/add/{stepIds}")
    public void addStepsToPath(@PathVariable("id") int id, @PathVariable("stepIds") List<Integer> stepIds, @RequestParam(value = "position", required = false) Optional<Integer> position) {
        int i = 0;
        for (Integer stepId : stepIds) {
            pathService.addStep(id, stepId, position.orElse(0) + i++);
        }
    }

    @PutMapping("/{id}/steps/remove/{stepId}")
    public void removeStepsFromPath(@PathVariable("id") int id, @PathVariable("stepId") Integer stepId) {
        pathService.removeStep(id, stepId);
    }

    @PutMapping("/{id}/clear")
    public void removeAllStepsFromPath(@PathVariable("id") int id) {
        pathService.removeAllSteps(id);
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
