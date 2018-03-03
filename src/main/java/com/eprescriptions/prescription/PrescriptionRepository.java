package com.eprescriptions.prescription;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long>{
	@Query
	List<Prescription> findAllByPatientId(int patient_id);
	
	@Query
	List<Prescription> findAllByDoctorId(long doctor_id);

}
