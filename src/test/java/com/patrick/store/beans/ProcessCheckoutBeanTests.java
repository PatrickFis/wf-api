/**
 * 
 */
package com.patrick.store.beans;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.patrick.store.interfaces.Cart;
import com.patrick.store.interfaces.Product;
import com.patrick.store.product.ProductImpl;

/**
 * @author Patrick
 *
 */
public class ProcessCheckoutBeanTests {
	
	@Mock
	private Cart cart;
	
	@InjectMocks
	private ProcessCheckoutBean process;// = new ProcessCheckoutBean();
	
	private List<Product> pList = new ArrayList<>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Product p = new ProductImpl();
		p.setName("Test Name");
		p.setDescription("Test Description");
		p.setPrice(1000.25);
		pList.add(p);
		
		cart = mock(Cart.class);
		MockitoAnnotations.initMocks(this);
		
		when(cart.getProductsInCart()).thenReturn(pList);
		when(cart.calculateTotalPrice()).thenReturn(p.getPrice());
	}

	/**
	 * Test method for {@link com.patrick.store.beans.ProcessCheckoutBean#getProductsInCart()}.
	 */
	@Test
	public void testGetProductsInCart() {
		assertTrue(process.getProductsInCart().equals(pList));
	}

	/**
	 * Test method for {@link com.patrick.store.beans.ProcessCheckoutBean#getTotalPrice()}.
	 */
	@Test
	public void testGetTotalPrice() {
		assertTrue(process.getTotalPrice() == 1000.25);
	}

	/**
	 * Test method for {@link com.patrick.store.beans.ProcessCheckoutBean#getPurchaseItems()}.
	 */
	@Test
	public void testGetPurchaseItems() {
		assertNull(process.getPurchaseItems());
	}

}
