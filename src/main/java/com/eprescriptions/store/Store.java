package com.eprescriptions.store;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName="store_seq", initialValue=1, name="store_seq")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="store_seq")
	Long id;
	String registration;
	String address;
	Double longitude;
	Double latitude;
	String openHours;
	LocalDateTime createdTs;
	LocalDateTime updatedTs;
}
