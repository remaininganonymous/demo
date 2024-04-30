package com.thesis.demo.services;

import com.thesis.demo.models.Experiment;
import com.thesis.demo.models.ExperimentData;
import com.thesis.demo.repositories.ExperimentDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperimentDataServiceImpl implements ExperimentDataService {

    @Autowired
    private final ExperimentDataRepository experimentDataRepository;

    public Optional<ExperimentData> getByExperiment(Experiment experiment) {

        return experimentDataRepository.findByExperiment(experiment);
    }

    public void save(ExperimentData experiment1Data) {

        experimentDataRepository.save(experiment1Data);
    }

    public void clearTable() {

        experimentDataRepository.deleteAll();
    }

    public void deleteById(Long id) {

        experimentDataRepository.deleteById(id);
    }

    public Boolean isTableEmpty() {
        //TODO: logic
        return false;
    }
}
