package com.example.Frontend.entity;


import lombok.Data;

@Data
public class ProductOrder {


	private Integer id;

	//private LocalDate orderDate;


	private Product product;

	private UserDtls userDtls;

	private String status;

	private String paymentType;


}
