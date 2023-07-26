package com.helmihealthcare.doctor;

import java.util.ArrayList;
import java.util.List;

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
		doctorRepository.save(doctor);
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
	
}
