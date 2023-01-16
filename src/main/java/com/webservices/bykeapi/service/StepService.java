package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Step;
import com.webservices.bykeapi.repository.StepRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {
    StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<Step> getAll() {
        return stepRepository.findAll();
    }

    public Step create(Step step) {
        return stepRepository.save(step);
    }

    public Step update(int id, Step step) {
        Step _step = stepRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Step not found")
        );
        BeanUtils.copyProperties(step, _step, "id");
        return stepRepository.save(_step);
    }
}
