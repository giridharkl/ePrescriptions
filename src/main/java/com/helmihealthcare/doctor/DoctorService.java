package com.helmihealthcare.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList = new ArrayList<>();
		doctorRepository.findAll().forEach(doctorList::add);
		return doctorList;
	}

	public Doctor getDoctor(Long id) {
		return doctorRepository.findById(id).get();
	}

	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	public void updateDoctor(Long id, Doctor doctor) {
		Optional<Doctor> docRep = doctorRepository.findById(id);
		if(docRep.isPresent()){
			Doctor doc = docRep.get();
			if(doctor.getAddress() != null){
				doc.setAddress(doctor.getAddress());
			}
			if(doctor.getEmail()!= null){
				doc.setEmail(doctor.getEmail());
			}
			if(doctor.getName() != null){
				doc.setName(doctor.getName());
			}
			if(doctor.getPhoneNumber() != 0){
				doc.setPhoneNumber(doctor.getPhoneNumber());
			}
			if(doctor.getSpecializations() != null){
				doc.setSpecializations(doctor.getSpecializations());
			}
			if(doctor.getWorkPlace() != null){
				doc.setWorkPlace(doctor.getWorkPlace());
			}
			doc.setUpdatedTimeStamp(doctor.getUpdatedTimeStamp());
			doctorRepository.save(doc);
		}
		
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
	
}
