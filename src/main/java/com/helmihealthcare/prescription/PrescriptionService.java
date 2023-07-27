package com.helmihealthcare.prescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public void updateprescription(Long id, Long docId, Long userId, Prescription prescription) {
		Optional<Prescription> prescriptionRep = prescriptionRepository.findById(id);
		if(prescriptionRep.isPresent()){
			Prescription pres = prescriptionRep.get();
			if(prescription.getDescription() != null){
				pres.setDescription(prescription.getDescription());
			}
			if(prescription.getMedicineName() != null){
				pres.setMedicineName(prescription.getMedicineName());
			}
			if(docId != 0){
				pres.setDocId(docId);
			}
			if(userId !=0){
				pres.setUserId(userId);
			}
			pres.setUpdatedTs(prescription.getUpdatedTs());
			prescriptionRepository.save(pres);
		}
	}
	

	public void deletePrescription(Long id) {
		prescriptionRepository.deleteById(id);
	}

	public List<Prescription> getAllPrescriptionBetweenDocIdUserId(Long docId, Long userId) {
		return prescriptionRepository.findByDocIdAndPatientId(docId, userId);
	}

}
