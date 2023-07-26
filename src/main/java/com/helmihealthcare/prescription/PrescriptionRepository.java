package com.helmihealthcare.prescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PrescriptionRepository extends CrudRepository<Prescription, Long>{
	
	public List<Prescription> findByDocId(Long docId);
	public List<Prescription> findByPatientId(Long patientId);
	public List<Prescription> findByDocIdAndPatientId(Long docId, Long patientId);
}
