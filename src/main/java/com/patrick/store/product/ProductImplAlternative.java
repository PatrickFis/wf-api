package com.patrick.store.product;

import com.patrick.store.interfaces.Product;

public class ProductImplAlternative implements Product {
	private String name;
	private double price;
	private String description;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price*2;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description.toUpperCase();
	}
}
