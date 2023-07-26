package com.helmihealthcare.doctor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.Id;


@Entity
@SequenceGenerator(sequenceName="doctor_seq", initialValue=1, name="docotr_seq")
public class Doctor {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="doctor_seq")
	Long Id;
	String Specializations;
	String name;
	String workPlace;
	String address;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	LocalDateTime createdTimeStamp;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	LocalDateTime updatedTimeStamp;
	int phoneNumber;
	String email;
	
	public Doctor() {
		
	}
	
	public Doctor(Long id) {
		super();
		this.Id = id;
	}

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSpecializations() {
		return Specializations;
	}
	public void setSpecializations(String specializations) {
		Specializations = specializations;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public LocalDateTime getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}
	public void setUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
