package com.patrick.store.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.store.interfaces.Cart;
import com.patrick.store.interfaces.Inventory;
import com.patrick.store.interfaces.Product;

@Named
@ViewScoped
public class StoreHomeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String storeName = "Test Store";
	@Inject
	private Inventory inventory;
	@Inject
	private Cart cart;
	
	public String getStoreName() {
		return this.storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public List<Product> getAllProducts() {
		return this.inventory.getAllProducts();
	}
	
	public void addItemToCart(Product p) {
		this.cart.addProductToCart(p);
	}
	
	public List<Product> getItemsInCart() {
		return this.cart.getProductsInCart();
	}
}
