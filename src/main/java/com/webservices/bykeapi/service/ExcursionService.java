package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.*;
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

    public Excursion create(ExcursionDto excursion) {
        Excursion newExcursion = new Excursion();
        newExcursion.setId2(0);

        ExcursionId id = new ExcursionId();
        id.setUserId(excursion.getUserId());
        id.setDeparture(excursion.getDeparture());

        User user = new User();
        user.setId(excursion.getUserId());

        Path path = new Path();
        path.setId(excursion.getPathId());

        Bike bike = new Bike();
        bike.setId(excursion.getBikeId());

        newExcursion.setId(id);
        newExcursion.setPath(path);
        newExcursion.setUser(user);
        newExcursion.setBike(bike);

        return excursionRepository.save(newExcursion);
    }

    public Excursion stop(int id, ExcursionDto excursionDto) {
        Excursion excursion = excursionRepository.findId(id);
        excursion.setArrival(excursionDto.getArrival());
        return excursionRepository.save(excursion);
    }

    public void update(int id, ExcursionDto excursionDto) {
        Excursion excursion = excursionRepository.findId(id);

        Bike bike = new Bike();
        bike.setId(excursionDto.getBikeId());
        Path path = new Path();
        path.setId(excursionDto.getPathId());

        excursion.setBike(bike);
        excursion.setPath(path);

        System.out.println("excursion: " + id + " -- " + excursionDto.getDeparture());

        excursionRepository.updateDeparture(id, excursionDto.getDeparture());
        excursionRepository.save(excursion);
    }

    public void delete(int id) {
        excursionRepository.delete(excursionRepository.findId(id));
    }
}
