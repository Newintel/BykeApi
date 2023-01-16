package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.*;
import com.webservices.bykeapi.repository.PathRepository;
import com.webservices.bykeapi.repository.PathstepRepository;
import com.webservices.bykeapi.repository.StepRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PathService {
    private final PathRepository pathRepository;
    private final PathstepRepository pathstepRepository;
    private final StepRepository stepRepository;

    public PathService(PathRepository pathRepository, PathstepRepository pathstepRepository, StepRepository stepRepository) {
        this.pathRepository = pathRepository;
        this.pathstepRepository = pathstepRepository;
        this.stepRepository = stepRepository;
    }

    public List<Path> getAll() {
        return pathRepository.findAll();
    }

    public Path getById(int id) {
        return pathRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid sortie Id:" + id)
        );
    }

    public List<Path> getByUserId(int id) {
        return pathRepository.findAll().stream().filter(path -> path.getCreator().getId() == id).collect(Collectors.toList());
    }

    public Path create(PathDto path) {
        Path newPath = new Path();
        newPath.setName(path.getName());
        User creator = new User();
        creator.setId(path.getCreatorId());
        newPath.setCreator(creator);
        return pathRepository.save(newPath);
    }

    public void delete(int id) {
        pathRepository.deleteById(id);
    }

    public void update(int id, Path sortie) {
        Path _path = pathRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        BeanUtils.copyProperties(sortie, _path, "id");

        pathRepository.save(_path);
    }

    public List<Path> getMostPopular() {
        return pathRepository.getMostPopular();
    }

    public void addStep(int id, int stepId, int position) {
        PathstepId pathstepId = new PathstepId();
        pathstepId.setPathId(id);
        pathstepId.setPosition(position);

        Path path = new Path();
        path.setId(id);

        Step step = new Step();
        step.setId(stepId);

        Pathstep pathstep = new Pathstep();
        pathstep.setId(pathstepId);
        pathstep.setStep(step);
        pathstep.setPath(path);

        pathstepRepository.modifyPositionFrom(id, position, 1);

        pathstepRepository.save(pathstep);
    }

    public void removeStep(int id, int position) {
        PathstepId pathstepId = new PathstepId();
        pathstepId.setPathId(id);
        pathstepId.setPosition(position);
        pathstepRepository.deleteById(pathstepId);
        pathstepRepository.modifyPositionFrom(id, position, -1);
    }
}
