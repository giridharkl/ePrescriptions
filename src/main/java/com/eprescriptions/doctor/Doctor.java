package com.eprescriptions.doctor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(sequenceName="doctor_seq", initialValue=1, name="doctor_seq")
public class Doctor {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="doctor_seq")
  Long id;
  String name;
  String registration;
  String work; //Hospital or Clinic
  String specialization;
  String address;
  Double longitude;
  Double latitiude;
  short deleted;
  String remarks;
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  LocalDateTime createdTs;
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  LocalDateTime updatedTs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitiude() {
		return latitiude;
	}
	public void setLatitiude(Double latitiude) {
		this.latitiude = latitiude;
	}
	public short getDeleted() {
		return deleted;
	}
	public void setDeleted(short deleted) {
		this.deleted = deleted;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDateTime getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}
	public LocalDateTime getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(LocalDateTime updatedTs) {
		this.updatedTs = updatedTs;
	}
}
