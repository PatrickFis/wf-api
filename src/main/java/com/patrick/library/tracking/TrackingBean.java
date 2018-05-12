package com.patrick.library.tracking;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.interfaces.BookTracker;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class TrackingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LibraryInventory library;
	
	@Inject
	private BookTracker tracker;
}
