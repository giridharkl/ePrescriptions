package com.eprescriptions.prescription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public List<Prescription> getPrescriptionByPatient(int patient_id) {
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		prescriptionRepository.findAllByPatientId(patient_id).forEach(prescriptionList::add);
		return prescriptionList;
	}
	
	public List<Prescription> getPrescriptionByDoctor(int doctor_id){
		List<Prescription> prescriptionList = new ArrayList<Prescription>();
		prescriptionRepository.findAllByDoctorId(doctor_id).forEach(prescriptionList::add);
		return prescriptionList;
	}
}
