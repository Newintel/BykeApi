package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.domain.ExcursionDto;
import com.webservices.bykeapi.service.ExcursionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/excursions")
public class ExcursionController {
    private final ExcursionService excursionService;

    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping("/user/{id}")
    public Object getExcursionsByUserId(@PathVariable("id") int id) {
        return excursionService.getByUserId(id);
    }

    @GetMapping("/{id}")
    public Object getExcursionById(@PathVariable("id") int id) {
        return excursionService.getById(id);
    }

    @PostMapping("")
    public Object createExcursion(@RequestBody ExcursionDto excursion) {
        return excursionService.create(excursion);
    }

    @PutMapping("/{id}/end")
    public void endExcursion(@PathVariable("id") int id, @RequestBody ExcursionDto excursion) {
        excursionService.stop(id, excursion);
    }

    @PutMapping("/{id}")
    public void updateExcursion(@PathVariable("id") int id, @RequestBody ExcursionDto excursion) {
        excursionService.update(id, excursion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        excursionService.delete(id);
    }
}
