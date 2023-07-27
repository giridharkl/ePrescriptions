package com.helmihealthcare.pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Optional<Pharmacy> pharmacyRep = pharmacyReposiotry.findById(id);
		if(pharmacyRep.isPresent()){
			Pharmacy pharma = pharmacyRep.get();
			if(pharmacy.getAddress() != null){
				pharma.setAddress(pharmacy.getAddress());
			}
			if(pharmacy.getRegistration() != null){
				pharma.setRegistration(pharmacy.getRegistration());
			}
			if(pharmacy.getVisitingHours() != null){
				pharma.setVisitingHours(pharmacy.getVisitingHours());
			}
			pharma.setUpdatedTimeStamp(pharmacy.getUpdatedTimeStamp());
			pharmacyReposiotry.save(pharma);
		}
	}

	public void deletePharmacy(Long id) {
		pharmacyReposiotry.deleteById(id);
	}

}
