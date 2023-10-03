package com.hritvik.SpringBootTechnicalAssignment.service;

import com.hritvik.SpringBootTechnicalAssignment.model.Doctor;
import com.hritvik.SpringBootTechnicalAssignment.model.Patient;
import com.hritvik.SpringBootTechnicalAssignment.model.enums.Speciality;
import com.hritvik.SpringBootTechnicalAssignment.repository.IDoctorRepo;
import com.hritvik.SpringBootTechnicalAssignment.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class DoctorSuggestionService {
    @Autowired
   private IPatientRepo patientRepo;
    @Autowired
   private IDoctorRepo doctorRepo;


    public List<String> getDoctorList(Integer patientId) {
        Patient currpatient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Invalid Patient ID"));
        String symptoms = String.valueOf(currpatient.getPatientSymptoms());
         String location = currpatient.getPatientCity();
//         System.out.println(location);


        for (String s : Arrays.asList("DELHI","NOIDA", "FARIDABAD")) {

            if(Objects.equals(location, s)){

                Speciality speciality = getSpeciality(symptoms);
                List<String> outputList = new ArrayList<>();
                List<Doctor> doctorList = doctorRepo.findByDoctorSpeciality(speciality);
                for(Doctor doctor:doctorList){
                    String docCity= String.valueOf(doctor.getDoctorCity());
                    if(docCity.equals(currpatient.getPatientCity())){
                        outputList.add(doctor.getDoctorName());
                    }
                }

                if(outputList.isEmpty()){
                    return List.of("There isn’t any doctor present at your location for your symptom");
                }
                return outputList;

            }
        }

        return List.of("We are still waiting to expand to your location");

    }

    private static Speciality getSpeciality(String symptoms) {
        Speciality speciality=null;
        if(symptoms.equals("Arthritis") || symptoms.equals("Back_Pain") || symptoms.equals("Tissue_Injuries") ){
            speciality= Speciality.valueOf("ORTHOPEDIC");
        }
        if(symptoms.equals("Dysmenorrhea")  ){
            speciality= Speciality.valueOf("GYNECOLOGY");
        }
        if(symptoms.equals("Skin_Infection") || symptoms.equals("Skin_Burn")  ){
            speciality= Speciality.valueOf("DERMATOLOGY");
        }
        if(symptoms.equals("Ear_pain") ){
            speciality= Speciality.valueOf(("ENT"));
        }
        return speciality;
    }

    public List<Doctor> getDoctorListBySpeciality(Speciality speciality) {

        return doctorRepo.findByDoctorSpeciality(speciality);
    }
}
