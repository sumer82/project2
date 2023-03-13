
package com.application.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.application.model.Appointment;
import com.application.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book/{p_id}/{d_id}")
    public Appointment addAppointment(@PathVariable int p_id, @PathVariable int d_id, @RequestBody Appointment appointment) {
        return appointmentService.createAppointment(p_id,d_id,appointment);
    }



    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }
    @GetMapping("/date")
    public  List<Appointment> getAppointmentByDate(@RequestParam("date") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return appointmentService.getAppointmentByDate(localDate);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable int patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable int doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/doctor/{doctorId}/{date}")
    public List<Appointment> getAppointmentsByDoctorIdAndDate(@PathVariable int doctorId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return appointmentService.getAppointmentsByDoctorIdAndDate(doctorId, date);
    }

    @GetMapping("/doctor/{doctorId}/{startDate}/{endDate}")
    public List<Appointment> getAppointmentsByDoctorIdAndDateRange(@PathVariable int doctorId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return appointmentService.getAppointmentsByDoctorIdAndDateRange(doctorId, startDate, endDate);
    }
}

