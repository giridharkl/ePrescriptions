package com.eprescriptions.doctor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
  @Autowired
  DoctorRepository doctorRepo;
  
  public List<Doctor> getAllDoctors() {
    List<Doctor> doctorList = new ArrayList<>();
    doctorRepo.findAll().forEach(doctorList::add);
    return doctorList;
  }
  
  public void addDoctor(Doctor doctor) {
    doctorRepo.save(doctor);
  }
  
  public void getDoctor(Long id) {
    doctorRepo.findOne(id);
  }
  
  public void updateDoctor(Doctor doctor) {
    doctorRepo.save(doctor);
  }
  
  public void deleteDoctor(Long id) {
    doctorRepo.delete(id);
  }
}
