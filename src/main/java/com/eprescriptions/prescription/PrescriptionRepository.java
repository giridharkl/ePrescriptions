package com.eprescriptions.prescription;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long>{
	
	Iterable<Prescription> findByPatientIdOrderByCreatedTsDesc(Long patient_id);
	
	Iterable<Prescription> findByDoctorIdOrderByCreatedTsDesc(Long doctor_id);
}
