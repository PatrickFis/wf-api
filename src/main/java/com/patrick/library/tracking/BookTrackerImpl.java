package com.patrick.library.tracking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.BookTracker;

@ApplicationScoped
public class BookTrackerImpl implements BookTracker, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<Book, Date> bookDueDates = new HashMap<>();
	private Map<Book, String> bookOwners = new HashMap<>();
	
	@Override
	public String getOwner(Book book) {
		return this.bookOwners.get(book);
	}

	@Override
	public Date getDueDate(Book book) {
		return this.bookDueDates.get(book);
	}
	
	@Override
	public Map<Book, Date> getDueDates() {
		return this.bookDueDates;
	}
	
	@Override
	public Map<Book, String> getBookOwners() {
		return this.bookOwners;
	}
	
	@Override
	public List<Book> getOverdueBooks() {
		List<Book> overdueBooks = new ArrayList<>();
		for(Book a: bookDueDates.keySet()) {
			if(bookDueDates.get(a).before(new Date())) {
				overdueBooks.add(a);
			}
		}
		return overdueBooks;
	}

	@Override
	public double calculateLateFees(Book book) {
		return 1000.25;
	}

	@Override
	public void setDueDate(Book book, Date dueDate) {
		this.bookDueDates.put(book, dueDate);
	}

	@Override
	public void removeDueDate(Book book) {
		this.bookDueDates.remove(book);
	}

	@Override
	public void setBookOwner(Book book, String owner) {
		this.bookOwners.put(book, owner);
	}

	@Override
	public void removeBookOwner(Book book) {
		this.bookOwners.remove(book);
	}

}
