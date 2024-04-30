package com.thesis.demo.config;

import com.thesis.demo.models.Experiment;
import com.thesis.demo.models.ExperimentData;
import com.thesis.demo.models.Patient;
import com.thesis.demo.services.ExperimentDataServiceImpl;
import com.thesis.demo.services.ExperimentServiceImpl;
import com.thesis.demo.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

@Component
public class DemoData {

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private ExperimentDataServiceImpl experimentDataService;

    @Autowired
    private PatientServiceImpl patientService;

    private final Boolean demoModeAllowed = true;

    //@Override
    public void run(String... args) throws Exception {
        if (demoModeAllowed == true) {
            //experimentService.clearTable();
            //experimentDataService.clearTable();
            //patientService.clearTable();

            Patient patient1 = Patient
                    .builder()
                    .name("Антонов Анатолий Николаевич")
                    .info("М, 12.09.1980")
                    .build();
            patientService.save(patient1);
            Experiment experiment1 = Experiment
                    .builder()
                    .patient(patient1)
                    .start(LocalDateTime.of(2024, 4, 26, 22, 50, 11))
                    .end(LocalDateTime.of(2024, 4, 26, 23, 40, 29))
                    .duration(LocalTime.of(0, 0, 0).plus(Duration.between(LocalDateTime.of(2024, 4, 26, 22, 50, 11), LocalDateTime.of(2024, 4, 26, 23, 40, 29))))
                    .description("Разнообразный и богатый опыт новая модель организационной деятельности влечет за собой процесс внедрения и модернизации модели развития. Равным образом дальнейшее развитие различных форм деятельности влечет за собой процесс внедрения и модернизации систем массового участия. Товарищи! реализация намеченных плановых заданий в значительной степени обуславливает создание системы обучения кадров, соответствует насущным потребностям. Разнообразный и богатый опыт начало повседневной работы по формированию позиции влечет за собой процесс внедрения и модернизации существенных финансовых и административных условий. Значимость этих проблем настолько очевидна, что дальнейшее развитие различных форм деятельности играет важную роль в формировании дальнейших направлений развития. Значимость этих проблем настолько очевидна, что сложившаяся структура организации в значительной степени обуславливает создание соответствующий условий активизации.\n" +
                            "\n" +
                            "Повседневная практика показывает, что постоянное информационно-пропагандистское обеспечение нашей деятельности требуют определения и уточнения системы обучения кадров, соответствует насущным потребностям. Не следует, однако забывать, что постоянный количественный рост и сфера нашей активности способствует подготовки и реализации системы обучения кадров, соответствует насущным потребностям. Задача организации, в особенности же начало повседневной работы по формированию позиции представляет собой интересный эксперимент проверки дальнейших направлений развития. Идейные соображения высшего порядка, а также постоянный количественный рост и сфера нашей активности играет важную роль в формировании системы обучения кадров, соответствует насущным потребностям.\n" +
                            "\n" +
                            "Повседневная практика показывает, что постоянное информационно-пропагандистское обеспечение нашей деятельности представляет собой интересный эксперимент проверки модели развития. Повседневная практика показывает, что консультация с широким активом обеспечивает широкому кругу (специалистов) участие в формировании системы обучения кадров, соответствует насущным потребностям.")
                    .build();
            experimentService.save(experiment1);
            ExperimentData experiment1Data = ExperimentData
                    .builder()
                    .experiment(experiment1)
                    .path("C:...")
                    .rhythm((double) 30)
                    .pace((double) 120)
                    .conclusions("Заключения те или иные")
                    .build();
            experimentDataService.save(experiment1Data);
            Patient patient2 = Patient
                    .builder()
                    .name("Павлов Анатолий Валерьевич")
                    .info("М, 14.09.1982")
                    .build();
            patientService.save(patient2);
            Experiment experiment2 = Experiment
                    .builder()
                    .patient(patient2)
                    .start(LocalDateTime.of(2024, 4, 26, 22, 50, 11))
                    .end(LocalDateTime.of(2024, 4, 26, 23, 40, 29))
                    .duration(LocalTime.of(0, 0, 0).plus(Duration.between(LocalDateTime.of(2024, 4, 26, 22, 50, 11), LocalDateTime.of(2024, 4, 26, 23, 40, 29))))
                    .description("Анализ походни пациента, подозрение на что-то там")
                    .build();
            experimentService.save(experiment2);
            ExperimentData experiment2Data = ExperimentData
                    .builder()
                    .experiment(experiment2)
                    .path("D:...")
                    .rhythm((double) 30)
                    .pace((double) 120)
                    .conclusions("Заключения те или иные, что угодно")
                    .build();
            experimentDataService.save(experiment2Data);
        }
    }
}