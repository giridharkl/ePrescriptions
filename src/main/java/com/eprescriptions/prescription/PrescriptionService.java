package com.eprescriptions.prescription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public List<Prescription> getPrescriptionByPatient(Long patient_id) {
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		prescriptionRepository.findByPatientIdOrderByCreatedTsDesc(patient_id).forEach(prescriptionList::add);
		return prescriptionList;
	}
	
	public List<Prescription> getPrescriptionByDoctor(Long doctor_id){
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		prescriptionRepository.findByDoctorIdOrderByCreatedTsDesc(doctor_id).forEach(prescriptionList::add);
		return prescriptionList;
	}
}
