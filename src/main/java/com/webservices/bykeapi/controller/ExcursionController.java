package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.domain.Excursion;
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
    public Object createExcursion(@RequestBody Excursion excursion) {
        return excursionService.create(excursion);
    }

    @PutMapping("/{id}")
    public void updateExcursion(@RequestBody Excursion excursion, @PathVariable("id") int id) {
        excursionService.update(id, excursion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        excursionService.delete(id);
    }
}
