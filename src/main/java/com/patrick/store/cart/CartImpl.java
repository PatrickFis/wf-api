package com.patrick.store.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.patrick.store.interfaces.Cart;
import com.patrick.store.interfaces.Product;

@Named
@SessionScoped
public class CartImpl implements Cart, Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger("cart");
	private List<Product> products = new ArrayList<>();
	
	@Override
	public List<Product> getProductsInCart() {
		return this.products;
	}

	@Override
	public void addProductToCart(Product product) {
		logger.log(Level.INFO, "Product added to cart");
		this.products.add(product);
		cartMessage(product);
	}

	@Override
	public void removeProductFromCart(Product product) {
		this.products.remove(product);
	}

	@Override
	public double calculateTotalPrice() {
		double price = 0;
		for(Product p: this.products) {
			price += p.getPrice();
		}
		return price;
	}

	@Override
	public int getTotalItemsInCart() {
		return this.products.size();
	}
	
	public void cartMessage(Product product) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Item added to cart", "Product: " + product.getName()));
	}
}
