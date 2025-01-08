package com.ecom_project_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DeliveryAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private Long  mobileNo;

	private String villageAndstreet;

	private String city;

	private String state;

	private int  pincode;

	public DeliveryAddress() {
	}

	public DeliveryAddress(Integer id, String firstName, String lastName, String email, Long mobileNo, String villageAndstreet, String city, String state, int pincode) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.villageAndstreet = villageAndstreet;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVillageAndstreet() {
		return villageAndstreet;
	}

	public void setVillageAndstreet(String villageAndstreet) {
		this.villageAndstreet = villageAndstreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "DeliveryAddress{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", mobileNo='" + mobileNo + '\'' +
				", villageAndstreet='" + villageAndstreet + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", pincode='" + pincode + '\'' +
				'}';
	}
}
