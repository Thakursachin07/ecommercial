package com.ecom_project_backend.entity;

import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;


@Entity
@Getter
@Setter
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private int quantity;

	@Transient
	private Double price;
	
	@Transient
	private Double totalPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart() {
	}

	public Cart(Integer id, Product product, User user, int quantity, Double price, Double totalPrice) {
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", product=" + product +
				", user=" + user +
				", quantity=" + quantity +
				", price=" + price +
				", totalPrice=" + totalPrice +
				'}';
	}
}
