package com.patrick.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.books.BookImpl;
import com.patrick.library.cdi.BookAdded;
import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class LibraryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LibraryInventory library;
	
	private String libraryName;
	
	private String libraryAddress;
	
	private String bookId;
	private String bookName;
	private String bookCheckedOut;

	@Inject
	@BookAdded
	Event<Book> bookAdded;
	
	public List<Book> getLibraryBooks() {
		return library.getBooks();
	}
	
	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCheckedOut() {
		return bookCheckedOut;
	}

	public void setBookCheckedOut(String bookCheckedOut) {
		this.bookCheckedOut = bookCheckedOut;
	}

	public void addBook() {
		boolean checkedOut;
		if(this.bookCheckedOut.equals("true")) {
			checkedOut = true;
		} else {
			checkedOut = false;
		}
		
		Book book = new BookImpl(this.bookId, this.bookName, checkedOut);
		library.addBook(book);
		bookAdded.fire(book);
	}
}
