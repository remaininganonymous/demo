package com.thesis.demo.repositories;

import com.thesis.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p NOT IN (SELECT e.patient FROM Experiment e)")
    List<Patient> findPatientsWithoutExperiments();
}
