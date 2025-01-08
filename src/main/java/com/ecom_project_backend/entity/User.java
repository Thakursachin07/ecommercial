package com.ecom_project_backend.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String mobileNumber;

	private String email;

	private String password;

	private String role;

	@OneToOne
	private DeliveryAddress deliveryAddress;

	@ManyToMany
	private List<ProductOrder> productOrders;

	//private String profileImage;


	public User() {
	}

	public User(Integer id, String name, String mobileNumber, String email, String password, String role, DeliveryAddress deliveryAddress, List<ProductOrder> productOrders) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.deliveryAddress = deliveryAddress;
		this.productOrders = productOrders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<ProductOrder> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				", deliveryAddress=" + deliveryAddress +
				", productOrders=" + productOrders +
				'}';
	}
}


