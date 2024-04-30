package com.thesis.demo.services;

import com.thesis.demo.models.Experiment;
import com.thesis.demo.repositories.ExperimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    private final ExperimentRepository experimentRepository;

    public List<Experiment> getAll() {
        return experimentRepository.findAll();
    }

    public void save(Experiment experiment) {
        experimentRepository.save(experiment);
    }

    public void clearTable() {
        experimentRepository.deleteAll();
    }

    public Optional<Experiment> getById(Long id) {
        return experimentRepository.findById(id);
    }

    public void deleteById(Long id) {
        experimentRepository.deleteById(id);
    }

    public Boolean isTableEmpty() {
        //TODO: logic
        return false;
    }
}
