package com.example.Frontend.entity;

import lombok.Data;

import java.util.List;

@Data
public class Product {


	private Integer id;


	private String title;


	private String description;

	private String category;

	private Double price;

	private int stock;

	private String images;

	private String image;

	private int discount;
	
	private Double discountPrice;


}
