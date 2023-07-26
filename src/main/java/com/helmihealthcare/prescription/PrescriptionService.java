package com.helmihealthcare.prescription;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionRepository prescriptionRepository;

	public List<Prescription> getAllprescriptions(Long id) {
		List<Prescription> prescriptions = new ArrayList<>();
		prescriptionRepository.findAll().forEach(prescriptions::add);
		return prescriptions;
	}

	public Prescription getprescription(Long id) {
		return prescriptionRepository.findById(id).get();
	}

	public void addprescription(Prescription prescription) {
		prescriptionRepository.save(prescription);
	}

	public void updateprescription(Prescription prescription) {
		prescriptionRepository.save(prescription);
	}
	

	public void deletePrescription(Long id) {
		prescriptionRepository.deleteById(id);
	}

	public List<Prescription> getAllPrescriptionBetweenDocIdUserId(Long docId, Long userId) {
		return prescriptionRepository.findByDocIdAndPatientId(docId, userId);
	}

}
