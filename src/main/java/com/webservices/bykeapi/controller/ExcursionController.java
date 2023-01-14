package com.webservices.bykeapi.controller;

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
}
