package com.hritvik.SpringBootTechnicalAssignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hritvik.SpringBootTechnicalAssignment.model.enums.Symptoms;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer patientId;

    @Size(min=3)
    private String patientName;
    @Size(max=20)
    private String patientCity;
    @Email
    @Column(unique = true)
    private String patientEmail;
    @Size(min=10)
    private String patientPhoneNumber;
    @Enumerated(EnumType.STRING)
    private Symptoms patientSymptoms;

}
