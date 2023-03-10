package com.application.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Appointment;
import com.application.model.Doctor;
import com.application.model.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

//    List<Appointment> findByDoctor(Doctor doctor);
//
//    List<Appointment> findByPatient(Patient patient);
//
//    List<Appointment> findByDate(LocalDate date);

	List<Appointment> findByPatientId(Long patientId);

	List<Appointment> findByDoctorId(Long doctorId);
    
	List<Appointment> findByDoctorIdAndDate(Long doctorId, LocalDate Date);

    List<Appointment> findByDoctorIdAndDateBetween(Long doctorId, LocalDate startDate, LocalDate endDate);
    // add other methods as per your requirements

	List<Appointment> findByDoctorIdAndDateAndTime(Long doctorId, LocalDate date, LocalTime time);

	List<Appointment> findByDate(LocalDate date);
}
