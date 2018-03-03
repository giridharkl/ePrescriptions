package com.eprescriptions.doctor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName="doctor_seq", initialValue=1, name="doctor_seq")
public class Doctor {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="doctor_seq")
  Long Id;
  String Name;
  String Registration;
  String Work; //Hospital or Clinic
  String Specialization;
  String Address;
  Double Longitude;
  Double Latitiude;
  short deleted;
  String Remarks;
  LocalDateTime created_ts;
  LocalDateTime updated_ts;
}
