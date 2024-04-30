package com.thesis.demo.services;

import com.thesis.demo.models.Experiment;
import com.thesis.demo.models.ExperimentData;

import java.util.Optional;

public interface ExperimentDataService {

    Optional<ExperimentData> getByExperiment(Experiment experiment);

    void save(ExperimentData experimentData);

    void deleteById(Long id);

}