package com.webservices.bykeapi.service;

import com.webservices.bykeapi.repository.SortieEntityRepository;
import com.webservices.bykeapi.domain.EntitySortie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {
    private final SortieEntityRepository sortieRepository;

    @Autowired
    public SortieService(SortieEntityRepository sortieRepository) {
        this.sortieRepository = sortieRepository;
    }

    public List<EntitySortie> getSorties() {
        return sortieRepository.findAll();
    }

    public EntitySortie getSortieById(int id) {
        return sortieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid sortie Id:" + id)
        );
    }

    public void addSortie(EntitySortie sortie) {
        sortieRepository.save(sortie);
    }

    public void deleteSortie(int id) {
        sortieRepository.deleteById(id);
    }

    public void updateSortie(int id, EntitySortie sortie) {
        EntitySortie _sortie = sortieRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        _sortie.merge(sortie);

        sortieRepository.save(_sortie);
    }
}
