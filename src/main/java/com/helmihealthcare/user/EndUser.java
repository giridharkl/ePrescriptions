package com.helmihealthcare.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
@SequenceGenerator(sequenceName="EndUser_Seq", initialValue=1, name="EndUser_Seq")
public class EndUser {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EndUser_Seq")
	Long Id;
	String name;
	String address;
	String phoneNumber;
	String verificationId;
	String email;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
