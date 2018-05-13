package com.patrick.library.checkout;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.cdi.BookCheckedOut;
import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class CheckoutBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LibraryInventory library;
	
	@Inject
	@BookCheckedOut
	private Event<Book> checkoutEvent;
	
	private String moreInfo;
	
	private Book selectedBook;
	
	private String ownerName;
	
	public List<Book> getBooks() {
		return this.library.getBooks();
	}
	
	public String getMoreInfo() {
		return this.moreInfo;
	}
	
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
	public Book getSelectedBook() {
		return this.selectedBook;
	}
	
	public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}
	
	public String getOwnerName() {
		return this.ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void checkoutBook(Book book) {
		library.checkOutBook(book.getBookId(), this.ownerName);
		checkoutEvent.fire(book);
	}
}
