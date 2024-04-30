package com.thesis.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Experiment experiment;

    private String path;

    private Double rhythm;

    private Double pace;

    private String conclusions; //заполняется вручную в форме

}
