package com.hritvik.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "event")
public class Event {
    @Id
    private Long eventId;

    @NotBlank(message = "name cannot be blank")
    private String userName;
    @NotBlank(message = "name cannot be blank")
    private String eventName;
    @NotBlank(message = "name cannot be blank")
    private String locationOfEvent;

    private LocalDate date;

    private LocalTime startTime;
    private LocalTime endTime;



}
