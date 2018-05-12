package com.patrick.library.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.cdi.BookAdded;
import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ApplicationScoped
public class LibraryInventoryImpl implements LibraryInventory, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("library");
	
	private List<Book> allBooks = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		generateDefaultData();
	}
	
	@Override
	public List<Book> getBooks() {
		return this.allBooks;
	}

	@Override
	public void checkOutBook(String bookId) {
		for(Book b: this.allBooks) {
			if(b.getBookId().equals(bookId)) {
				b.checkout();
			}
		}
		
	}

	@Override
	public void returnBook(String bookId) {
		for(Book b: this.allBooks) {
			if(b.getBookId().equals(bookId)) {
				b.returnBook();
			}
		}
		
	}
	
	@Override
	public void generateDefaultData() {
		Book a = new BookImpl("1", "Harry Potter", false);
		Book b = new BookImpl("2", "Earagon", false);
		Book c = new BookImpl("3", "Stephen King", false);
		Book d = new BookImpl("4", "Test Book!!!111one", false);
		
		this.allBooks.add(a);
		this.allBooks.add(b);
		this.allBooks.add(c);
		this.allBooks.add(d);
	}
	
	@Override
	public void addBook(Book book) {
		this.allBooks.add(book);
	}
}
