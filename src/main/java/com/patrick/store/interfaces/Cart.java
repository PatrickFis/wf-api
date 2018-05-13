package com.patrick.store.interfaces;

import java.util.List;

public interface Cart {
	public List<Product> getProductsInCart();
	public void addProductToCart(Product product);
	public void removeProductFromCart(Product product);
	public double calculateTotalPrice();
	public int getTotalItemsInCart();
}
