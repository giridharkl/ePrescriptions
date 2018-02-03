package com.eprescritions.store;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName="store_seq", initialValue=1, name="store_seq")
public class Store {

}
