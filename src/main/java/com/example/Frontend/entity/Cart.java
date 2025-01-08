package com.example.Frontend.entity;


public class Cart {


	private Integer id;

	private Product product;

	private UserDtls user;

	private int quantity;

	private Double price;

	private Double totalPrice;


	public Cart() {
	}

	public Cart(Integer id, Product product, UserDtls user, int quantity, Double price, Double totalPrice) {
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
	}

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

	public UserDtls getUser() {
		return user;
	}

	public void setUser(UserDtls user) {
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
