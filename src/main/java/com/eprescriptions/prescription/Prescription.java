package com.eprescriptions.prescription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
@SequenceGenerator(sequenceName="prescription_seq", initialValue=1, name="prescription_seq")
public class Prescription {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prescription_seq")
  Long Id;
}
