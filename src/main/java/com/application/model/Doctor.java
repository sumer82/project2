package com.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user = new User();
	
	private String speciality;
	private String degree;
	private LocalDate joiningDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctor")
	@JsonManagedReference
	private List<Appointment> appointments = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "doctor")
	@JsonManagedReference
	private List<Schedule> schedules;
	
	
	public Doctor() {
		super();
	}
	public Doctor(User user, String speciality, String degree, LocalDate joiningDate, List<Appointment> appointments) {
		super();
		this.user = user;
		this.speciality = speciality;
		this.degree = degree;
		this.joiningDate = joiningDate;
		this.appointments = appointments;
	}
	
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", user=" + user + ", speciality=" + speciality + ", degree=" + degree
				+ ", joiningDate=" + joiningDate + ", appointments=" + appointments + "]";
	}

	
	
	
}
