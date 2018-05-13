package com.patrick.store.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.store.interfaces.Cart;
import com.patrick.store.interfaces.Product;

@Named
@ViewScoped
public class ProcessCheckoutBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cart cart;
	
	public List<Product> getProductsInCart() {
		return this.cart.getProductsInCart();
	}
	
	public double getTotalPrice() {
		return this.cart.calculateTotalPrice();
	}
}
