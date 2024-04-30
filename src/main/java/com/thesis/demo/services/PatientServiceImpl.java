package com.thesis.demo.services;

import com.thesis.demo.models.Patient;
import com.thesis.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void save(Patient patient) {

        patientRepository.save(patient);
    }
    @Override
    public void clearTable() {
        patientRepository.deleteAll();
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public void delete(Long patientIdToDelete) {
        patientRepository.deleteById(patientIdToDelete);
    }

    @Override
    public List<Patient> getUnexamined() {
        return patientRepository.findPatientsWithoutExperiments();
    }
}
