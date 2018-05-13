package com.patrick.library.books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.LibraryInventory;

@Named
@ApplicationScoped
public class LibraryInventoryImpl implements LibraryInventory, Serializable {
	private static final long serialVersionUID = 1L;
	
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
	public void checkOutBook(String bookId, String owner) {
		for(Book b: this.allBooks) {
			if(b.getBookId().equals(bookId)) {
				b.checkout();
				b.setOwner(owner);
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
		Book a = new BookImpl("1", "Harry Potter", "It's about a wizard", false);
		Book b = new BookImpl("2", "Earagon", "Dragons. There be dragons.", false);
		Book c = new BookImpl("3", "Stephen King", "Horror.", false);
		Book d = new BookImpl("4", "Test Book!!!111one", "!test!", false);
		
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
