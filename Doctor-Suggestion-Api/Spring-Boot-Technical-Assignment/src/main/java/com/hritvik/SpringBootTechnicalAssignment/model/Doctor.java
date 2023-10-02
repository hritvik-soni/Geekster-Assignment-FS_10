package com.hritvik.SpringBootTechnicalAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hritvik.SpringBootTechnicalAssignment.model.enums.City;
import com.hritvik.SpringBootTechnicalAssignment.model.enums.Speciality;
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

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer doctorId;

    @Size(min=3)
    private String doctorName;
    @Enumerated(EnumType.STRING)
    private City doctorCity;
    @Email
    @Column(unique = true)
    private String doctorEmail;
    @Size(min=10)
    private String doctorPhoneNumber;
    @Enumerated(EnumType.STRING)
    private Speciality doctorSpeciality;

}
