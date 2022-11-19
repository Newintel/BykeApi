package com.webservices.bykeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.webservices.bykeapi.service.SortieService;
import com.webservices.bykeapi.domain.Sortie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Sortie> getSorties() {
        return sortieService.getSorties();
    }

    @GetMapping("/{id}")
    public Sortie getSortieById(@PathVariable("id") int id) {
        return sortieService.getSortieById(id);
    }

    @PostMapping("")
    public ResponseEntity addSortie(@RequestBody Sortie sortie) {
        Sortie _sortie = sortieService.addSortie(sortie);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.put("numSortie", _sortie.getId());

        return ResponseEntity.ok().body(node);
    }

    @PutMapping("/{id}")
    public void updateSortie(@RequestBody Sortie sortie, @PathVariable("id") int id) {
        sortieService.updateSortie(id, sortie);
    }

    @DeleteMapping("/{id}")
    public void deleteSortie(@PathVariable("id") int id) {
        sortieService.deleteSortie(id);
    }
}
