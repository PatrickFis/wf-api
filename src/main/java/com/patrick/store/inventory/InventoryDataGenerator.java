package com.patrick.store.inventory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.patrick.store.interfaces.Inventory;
import com.patrick.store.interfaces.Product;
import com.patrick.store.product.ProductImpl;
import com.patrick.store.product.ProductImplAlternative;

@Startup
@Singleton
public class InventoryDataGenerator {
	@Inject
	private Inventory inventory;
	
	@PostConstruct
	public void init() {
		Product p = new ProductImpl();
		p.setDescription("Test product desc");
		p.setName("Test Product");
		p.setPrice(100.29925);
		
		Product p2 = new ProductImplAlternative();
		p2.setDescription("Alternative product desc");
		p2.setName("Alternative Test Product");
		p2.setPrice(1000029.0);
		
		inventory.addProduct(p);
		inventory.addProduct(p2);
	}
}
