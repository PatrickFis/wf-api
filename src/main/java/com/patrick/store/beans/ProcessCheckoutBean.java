package com.patrick.store.beans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.store.interfaces.Cart;
import com.patrick.store.interfaces.Product;

@Named
@ViewScoped
public class ProcessCheckoutBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("processCheckout");
	
	@Inject
	private Cart cart;
	
	private List<Product> purchaseItems;
	private String customerName;
	private String customerAddress;
	
	public List<Product> getProductsInCart() {
		return this.cart.getProductsInCart();
	}
	
	public double getTotalPrice() {
		return this.cart.calculateTotalPrice();
	}
	
	public List<Product> getPurchaseItems() {
		return this.purchaseItems;
	}
	
	public void setPurchaseItems(List<Product> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public void submitPurchase() {
		logger.log(Level.INFO, "Customer name {0}. Customer address {1}.", new Object[] {customerName, customerAddress});
	}
}
