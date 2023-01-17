package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Step;
import com.webservices.bykeapi.domain.StepDto;
import com.webservices.bykeapi.domain.User;
import com.webservices.bykeapi.repository.StepRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StepService {
    StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<Step> getAll() {
        return stepRepository.findAll();
    }

    public Step create(StepDto step) {
        Step newStep = new Step();
        newStep.setLatitude(step.getLatitude());
        newStep.setLongitude(step.getLongitude());
        newStep.setLocation(step.getLocation());

        User creator = new User();
        creator.setId(step.getCreatorId());

        newStep.setCreator(creator);

        return stepRepository.save(newStep);
    }

    public Step update(int id, Step step) {
        Step _step = stepRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Step not found")
        );
        BeanUtils.copyProperties(step, _step, "id", "user");
        return stepRepository.save(_step);
    }

    public List<Integer> createAll(List<StepDto> steps) {
        return steps.stream().map(step -> create(step).getId()).collect(Collectors.toList());
    }
}
