package com.thesis.demo.controllers;

import com.thesis.demo.DTO.PatientRegistrationDTO;
import com.thesis.demo.models.Patient;
import com.thesis.demo.services.PatientRegistrationService;
import com.thesis.demo.services.PatientService;
import com.thesis.demo.services.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewPatientController { //TODO: возможность удалить пациента, за которым нет экспериментов

    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/createPerson")
    public String showPatientForm(Model model) {
        model.addAttribute("PatientRegistrationDTO", new PatientRegistrationDTO());
        List<Patient> patientList = patientService.getAll();
        //model.addAttribute("patientsToDelete", patientList);
        List<Patient> unexmined = patientService.getUnexamined();
        model.addAttribute("patientsToDelete", unexmined);
        //System.out.println(patientList.toString());
        return "new_patient";
    }

    @PostMapping("/createPerson")
    public String createPerson(@ModelAttribute("patientRegistrationDTO")
                                   @Valid PatientRegistrationDTO patientRegistrationDTO,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_patient";
        }
        patientRegistrationService.addPatient(patientRegistrationDTO);
        return "redirect:/"; //TODO
    }

    @PostMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientIdToDelete") Long patientIdToDelete) {
        patientService.delete(patientIdToDelete);
        return "redirect:/createPerson";
    }

}
