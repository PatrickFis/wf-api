package com.patrick.library.checkout;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class CheckoutBean {
	@Inject
	private LibraryInventory library;
	
}
