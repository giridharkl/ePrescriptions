package com.helmihealthcare.pharmacy;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(sequenceName="Store_Seq", initialValue=1, name="Store_Seq")
public class Pharmacy {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Sote_Seq")
	Long id;
	String registration;
	String address;
	String visitingHours;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	LocalDateTime createdTimeStamp;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	LocalDateTime updatedTimeStamp;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVisitingHours() {
		return visitingHours;
	}
	public void setVisitingHours(String visitingHours) {
		this.visitingHours = visitingHours;
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
	
}
