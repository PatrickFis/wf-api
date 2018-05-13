package com.patrick.store.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.patrick.store.interfaces.Inventory;
import com.patrick.store.interfaces.Product;

@ApplicationScoped
public class InventoryImpl implements Inventory, Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Product> inventory = new ArrayList<>();
	private Map<Product, Double> productPrices = new HashMap<>();
	
	@Override
	@Produces
	@ProductInventory
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.inventory;
	}

	@Override
	public Map<Product, Double> getAllProductPrices() {
		for(Product product: inventory) {
			productPrices.put(product, product.getPrice());
		}
		return this.productPrices;
	}

	@Override
	public void addProduct(Product product) {
		this.inventory.add(product);
		this.productPrices.put(product, product.getPrice());
	}
	
}
