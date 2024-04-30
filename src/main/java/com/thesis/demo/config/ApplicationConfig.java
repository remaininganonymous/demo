package com.thesis.demo.config;

import com.thesis.demo.DTO.PatientRegistrationDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PatientRegistrationDTO patientRegistrationDTO() {

        return new PatientRegistrationDTO();
    }
}
