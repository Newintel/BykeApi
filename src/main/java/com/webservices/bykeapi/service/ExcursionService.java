package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Excursion;
import com.webservices.bykeapi.domain.ExcursionDto;
import com.webservices.bykeapi.domain.User;
import com.webservices.bykeapi.repository.ExcursionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcursionService {
    private final ExcursionRepository excursionRepository;

    public ExcursionService(ExcursionRepository excursionRepository) {
        this.excursionRepository = excursionRepository;
    }

    public List<Excursion> getByUserId(int id) {
        User user = new User();
        user.setId(id);
        Excursion excursion = new Excursion();
        excursion.setUser(user);
        return excursionRepository.findAll(Example.of(excursion));
    }

    public Excursion getById(int id) {
        return excursionRepository.findId(id);
    }

    public Excursion create(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    public Excursion stop(int id, ExcursionDto excursionDto) {
        Excursion excursion = excursionRepository.findId(id);
        BeanUtils.copyProperties(excursionDto, excursion, "id");
        return excursionRepository.save(excursion);
    }

    public void delete(int id) {
        excursionRepository.delete(excursionRepository.findId(id));
    }
}
