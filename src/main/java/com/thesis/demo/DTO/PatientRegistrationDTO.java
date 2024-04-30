package com.thesis.demo.DTO;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
public class PatientRegistrationDTO {

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @NonNull
    private String info;

}