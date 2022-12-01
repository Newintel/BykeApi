package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Path;
import com.webservices.bykeapi.repository.PathRepository;
import com.webservices.bykeapi.domain.Path;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathService {
    private final PathRepository pathRepository;

    @Autowired
    public PathService(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    public List<Path> getAll() {
        return pathRepository.findAll();
    }

    public Path getById(int id) {
        return pathRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid sortie Id:" + id)
        );
    }

    public Path create(Path path) {
        return pathRepository.save(path);
    }

    public void delete(int id) {
        pathRepository.deleteById(id);
    }

    public void update(int id, Path sortie) {
        Path _path = pathRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        BeanUtils.copyProperties(sortie, _path, "id");

        pathRepository.save(_path);
    }
}
