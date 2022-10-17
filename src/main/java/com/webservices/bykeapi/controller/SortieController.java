package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.service.SortieService;
import com.webservices.bykeapi.domain.EntitySortie;
import com.webservices.bykeapi.utils.PostRequestReturn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sorties")
public class SortieController {
    private final SortieService sortieService;

    public SortieController(SortieService sortieService) {
        this.sortieService = sortieService;
    }

    @GetMapping("")
    public List<EntitySortie> getSorties() {
        return sortieService.getSorties();
    }

    @GetMapping("/{id}")
    public EntitySortie getSortieById(@PathVariable("id") int id) {
        return sortieService.getSortieById(id);
    }

    @PostMapping("")
    public ResponseEntity addSortie(@RequestBody EntitySortie sortie) {
        PostRequestReturn<EntitySortie> obj = sortieService.addSortie(sortie);

        return ResponseEntity.ok().body(obj.getJson());
    }

    @PutMapping("/{id}")
    public void updateSortie(@RequestBody EntitySortie sortie, @PathVariable("id") int id) {
        sortieService.updateSortie(id, sortie);
    }

    @DeleteMapping("/{id}")
    public void deleteSortie(@PathVariable("id") int id) {
        sortieService.deleteSortie(id);
    }
}
