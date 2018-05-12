package com.patrick.library.admin;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.interfaces.BookTracker;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LibraryInventory library;
	@Inject
	private BookTracker tracker;
}
