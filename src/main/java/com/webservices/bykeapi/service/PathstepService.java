package com.webservices.bykeapi.service;

import com.webservices.bykeapi.domain.Pathstep;
import com.webservices.bykeapi.repository.PathstepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathstepService {
    PathstepRepository pathstepRepository;

    public PathstepService(PathstepRepository pathstepRepository) {
        this.pathstepRepository = pathstepRepository;
    }
}
