package com.eprescriptions.patient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
@SequenceGenerator(sequenceName="patient_seq", initialValue=1, name="patient_seq")
public class Patient {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="patient_seq")
  Long Id;
  String Name;
}
