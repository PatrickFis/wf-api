package com.patrick.store.interfaces;

import java.util.List;
import java.util.Map;

public interface Inventory {
	public List<Product> getAllProducts();
	public Map<Product, Double> getAllProductPrices();
	public void addProduct(Product product);
}
