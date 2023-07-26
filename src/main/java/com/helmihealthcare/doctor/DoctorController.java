package com.helmihealthcare.doctor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DoctorController {
	
	Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/doctors")
	List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@RequestMapping("/doctor/{id}")
	Doctor getDoctorById(@PathVariable Long id) {
		return doctorService.getDoctor(id);
	}
	
	
	 @RequestMapping(method=RequestMethod.POST, value = "/doctors") 
	 void addDoctor(@RequestBody Doctor doctor) { doctorService.addDoctor(doctor); }
	 
	
	@RequestMapping(method=RequestMethod.PUT, value = "/doctors/{id}")
	void updateDoctor(@PathVariable Long id ,@RequestBody Doctor doctor) {
		doctorService.updateDoctor(id, doctor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/doctors/{id}")
	public void deletetDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
	}
	
	 @RequestMapping(method=RequestMethod.POST, value = "/iot") 
	 void processIOT(@RequestBody String iot) {
		 logger.debug(iot);
	 }
}
