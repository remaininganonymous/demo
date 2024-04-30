package com.thesis.demo.controllers;

import com.thesis.demo.models.ChartData;
import com.thesis.demo.models.Experiment;
import com.thesis.demo.models.ExperimentData;
import com.thesis.demo.models.Patient;
import com.thesis.demo.models.enums.Leg;
import com.thesis.demo.services.ExperimentDataServiceImpl;
import com.thesis.demo.services.ExperimentServiceImpl;
import com.thesis.demo.util.processing.CSVtoListConverterAccel;
import com.thesis.demo.util.processing.CSVtoListConverterGyro;
import com.thesis.demo.util.processing.ListToCSVConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ExperimentController {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private ExperimentDataServiceImpl experimentDataService;

    @Autowired
    private CSVtoListConverterAccel CSVtoAccel;

    @Autowired
    private CSVtoListConverterGyro CSVtoGyro;

    @GetMapping("/experiment/{id}")
    public String expInfo (@PathVariable Long id, Model model) {
        Optional<Experiment> experiment = experimentService.getById(id);
        if (experiment.isPresent()) {
            Optional<ExperimentData> experimentData = experimentDataService.getByExperiment(experiment.get());
            Patient patient = experiment.get().getPatient();
            model.addAttribute("experiment", experiment.get());
            model.addAttribute("experimentData", experimentData.get());
            model.addAttribute("patient", patient);

            ListToCSVConverter listToCSVConverter = new ListToCSVConverter();
            CSVtoListConverterAccel CSVtoListAccel = new CSVtoListConverterAccel();
            CSVtoListConverterGyro CSVtoListGyro = new CSVtoListConverterGyro();

            List<ChartData> accelBefore = new ArrayList<>();
            for (double i = 0; i <= 6.28; i+=0.001) {
                accelBefore.add(new ChartData(String.format("%.3f", i), Math.sin(i)));
            }

            List<ChartData> gyroBefore = new ArrayList<>();
            for (double i = 0; i <= 6.28; i+=0.001) {
                gyroBefore.add(new ChartData(String.format("%.3f", i), Math.cos(i)/2));
            }
            String pathBefore = listToCSVConverter.ListToCSV(accelBefore, gyroBefore, Leg.LEFT, false);

            List<ChartData> accelAfter = new ArrayList<>();
            for (double i = 0; i <= 6.28; i+=0.001) {
                accelAfter.add(new ChartData(String.format("%.3f", i), Math.sin(i)/1.5));
            }

            List<ChartData> gyroAfter = new ArrayList<>();
            for (double i = 0; i <= 6.28; i+=0.001) {
                gyroAfter.add(new ChartData(String.format("%.3f", i), Math.cos(i)/3));
            }
            String pathAfter = listToCSVConverter.ListToCSV(accelAfter, gyroAfter, Leg.LEFT, true);

            model.addAttribute("accelBefore", CSVtoListAccel.CSVtoList(pathBefore));
            model.addAttribute("gyroBefore", CSVtoListGyro.CSVtoList(pathBefore));
            model.addAttribute("accelAfter", CSVtoListAccel.CSVtoList(pathAfter));
            model.addAttribute("gyroAfter", CSVtoListGyro.CSVtoList(pathAfter));

            return "exp_info"; //TODO: сделать так, чтобы бралось из incoming files
        } else {
            return "404"; //TODO
        }

    }

    @PostMapping("/experiment/{id}/delete")
    public String deleteExp (@PathVariable Long id) {
        experimentService.deleteById(id);
        experimentDataService.deleteById(id);
        return "redirect:/";
    }


}
