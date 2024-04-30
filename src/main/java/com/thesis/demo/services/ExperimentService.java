package com.thesis.demo.services;


import com.thesis.demo.models.Experiment;

import java.util.List;
import java.util.Optional;

public interface ExperimentService {

    List<Experiment> getAll();

    void save(Experiment experiment);

    Optional<Experiment> getById(Long id);

    void deleteById(Long id);
}
