package com.eprescriptions.prescription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ForeignKey;

import com.eprescriptions.doctor.Doctor;
import com.eprescriptions.patient.Patient;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SequenceGenerator(sequenceName="prescription_seq", initialValue=1, name="prescription_seq")
public class Prescription {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prescription_seq")
  Long Id;
  
  @ManyToOne
  @JoinColumn(name="patient_id", referencedColumnName="Id")
  private Patient patient;
  
  @ManyToOne
  @JoinColumn(name="doctor_id", referencedColumnName="Id")
  private Doctor doctor;
}
