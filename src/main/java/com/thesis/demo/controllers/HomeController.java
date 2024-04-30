package com.thesis.demo.controllers;

import com.thesis.demo.config.DemoData;
import com.thesis.demo.models.Experiment;
import com.thesis.demo.services.ExperimentDataServiceImpl;
import com.thesis.demo.services.ExperimentServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private ExperimentDataServiceImpl experimentDataService;

    @Autowired
    private DemoData demoData;

    @GetMapping("/")
    public String home(Model model) {

        List<Experiment> experiments = experimentService.getAll();
        model.addAttribute("experiments", experiments);

        return "home";
    }

    @PostMapping("/rundemo")
    public String runDemo() {
        try {
            demoData.run();
        } catch (Exception e) {

        }
        return "redirect:/";
    }

    @PostMapping("/clear")
    public String clearExperiments() {
        try {
            experimentService.clearTable();
            experimentDataService.clearTable();
        } catch (Exception e) {

        }

        return "redirect:/";
    }

    @PostMapping("/new-exp")
    public String newExperiment() {
        //TODO: после возможности добавления пациента
        return "new_exp";
    }

    @GetMapping("/new-patient")
    public String newPatient() {

        return "new_patient";
    }

}
