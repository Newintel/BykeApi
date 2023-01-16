package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.domain.Step;
import com.webservices.bykeapi.service.StepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/steps")
public class StepController {
    StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping("")
    public List<Step> getSteps() {
        return stepService.getAll();
    }

    @PostMapping("")
    public Step createStep(@RequestBody Step step) {
        return stepService.create(step);
    }

    @PutMapping("/{id}")
    public Step updateStep(@RequestBody Step step, @PathVariable("id") int id) {
        return stepService.update(id, step);
    }
}
