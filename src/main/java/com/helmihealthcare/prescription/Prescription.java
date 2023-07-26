package com.helmihealthcare.prescription;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import com.helmihealthcare.doctor.Doctor;
import com.helmihealthcare.user.EndUser;

import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
@SequenceGenerator(sequenceName="Prescription_Seq", initialValue=1, name="Prescription_Seq")
public class Prescription {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Prescription_Seq")
	Long Id;
	String medicineName;
	String description;
	LocalDateTime createdTs;
	LocalDateTime updatedTs;
	Long docId;
	Long patientId;
	
	public Long getDocId() {
		return docId;}
	
	@ManyToOne
	Doctor doctor;
	
	@ManyToOne
	EndUser EndUser;
	
	public Long getPatientId() {
		return patientId;
	}



	public void setUserId(Long userId) {
		this.patientId = userId;
	}



	public void setDocId(Long docId) {
		this.docId = docId;
	}



	public Prescription() {
	
	}
	

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
