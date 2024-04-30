package com.thesis.demo.repositories;

import com.thesis.demo.models.Experiment;
import com.thesis.demo.models.ExperimentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperimentDataRepository extends JpaRepository<ExperimentData, Long> {

    Optional<ExperimentData> findByExperiment(Experiment experiment);


}
