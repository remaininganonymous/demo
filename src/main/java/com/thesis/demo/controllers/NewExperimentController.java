package com.thesis.demo.controllers;

import com.thesis.demo.services.ExperimentDataServiceImpl;
import com.thesis.demo.services.ExperimentServiceImpl;
import com.thesis.demo.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewExperimentController {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private ExperimentDataServiceImpl experimentDataService;

    @Autowired
    private PatientServiceImpl patientService;
    
    @GetMapping("/startExperiment")
    public String startNewExperiment(Model model) {

        return "new_exp";
    }
}
