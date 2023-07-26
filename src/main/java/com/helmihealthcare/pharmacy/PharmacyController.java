package com.helmihealthcare.pharmacy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PharmacyController {

	@Autowired
	private PharmacyService pharmacyService;
	
	@RequestMapping("/pharmacy")
	List<Pharmacy> getAllPharmacy(){
		return pharmacyService.getAllPharmacy();
	}
	
	@RequestMapping("/pharmacy/{id}")
	Pharmacy getPharmacyById(@PathVariable Long id) {
		return pharmacyService.getPharmacy(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/pharmacy")
	public void addPharmacy(@RequestBody Pharmacy pharmacy) {
		pharmacyService.addPharmacy(pharmacy);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/pharmacy/{id}")
	public void updatePharmacy(@PathVariable Long id ,@RequestBody Pharmacy pharmacy) {
		pharmacyService.updatePharmacy(id, pharmacy);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/pharmacy/{id}")
	public void deletetPharmacy(@PathVariable Long id) {
		pharmacyService.deletePharmacy(id);
	}
}
