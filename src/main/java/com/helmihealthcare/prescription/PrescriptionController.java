package com.helmihealthcare.prescription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;
	
	@RequestMapping("/doctor/{docId}/prescriptions")
	List<Prescription> getAllDoctors(@PathVariable Long docId){
		return prescriptionService.getAllprescriptions(docId);
	}
	
	@RequestMapping("/doctor/{docId}/user/{userId}/prescriptions")
	List<Prescription> getAllBetween(@PathVariable Long docId, @PathVariable Long userId){
		return prescriptionService.getAllPrescriptionBetweenDocIdUserId(docId, userId);
	}
	
	@RequestMapping("/doctor/{docId}/prescription/{id}")
	Prescription getprescriptionById(@PathVariable Long id) {
		return prescriptionService.getprescription(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/doctor/{docId}/user/{userId}/prescriptions")
	public void addprescription(@RequestBody Prescription prescription, @PathVariable Long docId, @PathVariable Long userId) {
		prescription.setDocId(docId);
		prescription.setUserId(userId);
		prescriptionService.addprescription(prescription);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/doctor/{docId}/users/{userId}/prescription/{id}")
	public void updatePrescription(@PathVariable Long id , @RequestBody Prescription prescription, @PathVariable Long docID, @PathVariable Long userId) {
		prescriptionService.updateprescription(id, docID, userId, prescription);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/doctor/{docId}/prescription/{id}")
	public void deletetPrescription(@PathVariable Long id) {
		prescriptionService.deletePrescription(id);
	}
}
