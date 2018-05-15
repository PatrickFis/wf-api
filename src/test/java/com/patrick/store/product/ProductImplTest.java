package com.patrick.store.product;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.patrick.store.interfaces.Product;

public class ProductImplTest {
	@Test
	public void testProduct() {
		Product p = new ProductImpl();
		p.setName("test");
		p.setDescription("test");
		p.setPrice(1000.25);
		
		assertTrue(p.getName().equals("test"));
		assertTrue(p.getDescription().equals("test"));
		assertTrue(p.getPrice() == 1000.25);
	}
}

