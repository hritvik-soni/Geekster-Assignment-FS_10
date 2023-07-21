package com.hritvik.DoctorAPP.repository;

import com.hritvik.DoctorAPP.model.Appointment;
import com.hritvik.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment,Long> {

    Appointment findFirstByPatient(Patient patient);
}
