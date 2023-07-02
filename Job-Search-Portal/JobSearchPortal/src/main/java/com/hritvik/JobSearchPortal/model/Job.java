package com.hritvik.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    @NotBlank(message = "Title cant be Blank")
    private String title;

    @NotBlank(message = "Description cant be Blank")
    private String description;

    @NotBlank(message = "Location cant be Blank")
    private String location;

    @Min(value = 20000)
    private Double salary;

    @Email
    private String companyEmail;

    @Pattern(regexp = "[A-Z][a-zA-z0-9 ]*")
    private String companyName;

    @Pattern(regexp = "[A-Z][a-zA-z0-9 ]*")
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType; // enum class

    private LocalDate appliedDate; //2023-07-02
}
