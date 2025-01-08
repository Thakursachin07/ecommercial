package com.ecom_project_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate orderDate;

	@ManyToOne
	private Product product;


	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User users;

	private String status;

	private String paymentType;


	public ProductOrder(){}

	public ProductOrder(Integer id, LocalDate orderDate, Product product, User users, String status, String paymentType) {
		this.id = id;
		this.orderDate = orderDate;
		this.product = product;
		this.users = users;
		this.status = status;
		this.paymentType = paymentType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "ProductOrder{" +
				"id=" + id +
				", orderDate=" + orderDate +
				", product=" + product +
				", users=" + users +
				", status='" + status + '\'' +
				", paymentType='" + paymentType + '\'' +
				'}';
	}
}
