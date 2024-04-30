package com.thesis.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experiment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Patient patient; //выбирается из списка в форме

    private LocalDateTime start;

    private LocalDateTime end;

    private LocalTime duration;

    private String description; //жалобы и тд, заполняется в форме

}
