package com.eprescriptions.store;

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
	Long Id;
}
