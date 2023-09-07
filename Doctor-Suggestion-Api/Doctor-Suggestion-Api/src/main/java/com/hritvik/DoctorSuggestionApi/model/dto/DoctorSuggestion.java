package com.hritvik.DoctorSuggestionApi.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSuggestion {

    private Long patientId;
    private String symptoms;
}
