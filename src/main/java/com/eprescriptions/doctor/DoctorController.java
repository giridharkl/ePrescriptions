package com.eprescriptions.doctor;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value="/ePrescriptions/doctors", method = RequestMethod.GET)
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
		//return "Hello List of Doctors";
	}
	
	@RequestMapping(value="/ePrescriptions/doctors", method = RequestMethod.POST)
	public Doctor newDoctor(@RequestBody Doctor doctor) {
		return doctorService.newDoctor(doctor);
	}
	

}
