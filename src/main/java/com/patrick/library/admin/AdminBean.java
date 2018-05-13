package com.patrick.library.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.interfaces.Book;
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
	
	public List<Book> getCheckedOutBooks() {
		List<Book> checkedOut = new ArrayList<>();
		checkedOut.addAll(tracker.getBookOwners().keySet());
		return checkedOut;
	}
	
	public List<Book> getAllBooks() {
		return library.getBooks();
	}
}
