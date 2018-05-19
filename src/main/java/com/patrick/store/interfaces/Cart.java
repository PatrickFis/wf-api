package com.patrick.store.interfaces;

import java.util.List;

import com.patrick.store.noncdi.MonitoredMethod;

public interface Cart {
	@MonitoredMethod
	public List<Product> getProductsInCart();
	@MonitoredMethod
	public void addProductToCart(Product product);
	@MonitoredMethod
	public void removeProductFromCart(Product product);
	@MonitoredMethod
	public double calculateTotalPrice();
	@MonitoredMethod
	public int getTotalItemsInCart();
}
