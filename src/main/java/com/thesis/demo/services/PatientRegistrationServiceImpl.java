package com.thesis.demo.services;

import com.thesis.demo.DTO.PatientRegistrationDTO;
import com.thesis.demo.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {

    @Autowired
    private PatientService patientService;

    @Override
    public void addPatient(PatientRegistrationDTO patientRegistrationDTO) {
        Patient patient = new Patient();
        patient.setName(patientRegistrationDTO.getName());
        patient.setInfo(patientRegistrationDTO.getInfo());
        patientService.save(patient);
    }
}
