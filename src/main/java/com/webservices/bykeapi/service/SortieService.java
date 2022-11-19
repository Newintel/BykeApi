package com.webservices.bykeapi.service;

import com.webservices.bykeapi.repository.SortieRepository;
import com.webservices.bykeapi.domain.Sortie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {
    private final SortieRepository sortieRepository;

    @Autowired
    public SortieService(SortieRepository sortieRepository) {
        this.sortieRepository = sortieRepository;
    }

    public List<Sortie> getSorties() {
        return sortieRepository.findAll();
    }

    public Sortie getSortieById(int id) {
        return sortieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid sortie Id:" + id)
        );
    }

    public Sortie addSortie(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    public void deleteSortie(int id) {
        sortieRepository.deleteById(id);
    }

    public void updateSortie(int id, Sortie sortie) {
        Sortie _sortie = sortieRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        BeanUtils.copyProperties(sortie, _sortie, "id");

        sortieRepository.save(_sortie);
    }
}
