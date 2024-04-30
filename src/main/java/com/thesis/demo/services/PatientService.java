package com.thesis.demo.services;

import com.thesis.demo.models.Patient;

import java.util.List;

public interface PatientService {

    void save(Patient patient);

    void clearTable();

    List<Patient> getAll();

    void delete(Long patientIdToDelete);

    List<Patient> getUnexamined();
}
