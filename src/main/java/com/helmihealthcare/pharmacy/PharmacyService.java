package com.helmihealthcare.pharmacy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {
	
	@Autowired
	private PharmacyReposiotry pharmacyReposiotry;

	public List<Pharmacy> getAllPharmacy() {
		List<Pharmacy> pharmacies = new ArrayList<>();
		pharmacyReposiotry.findAll().forEach(pharmacies::add);
		return pharmacies;
	}

	public Pharmacy getPharmacy(Long id) {
		return pharmacyReposiotry.findById(id).get();
	}

	public void addPharmacy(Pharmacy pharmacy) {
		pharmacyReposiotry.save(pharmacy);
	}

	public void updatePharmacy(Long id, Pharmacy pharmacy) {
		pharmacyReposiotry.save(pharmacy);
	}

	public void deletePharmacy(Long id) {
		pharmacyReposiotry.deleteById(id);
	}

}
