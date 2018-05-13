package com.patrick.library.cdi;

import java.util.Date;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.patrick.library.interfaces.Book;
import com.patrick.library.interfaces.BookTracker;

@Singleton
public class CheckoutObserver {
	@Inject
	private BookTracker tracker;
	
	public void bookCheckedOut(@Observes @BookCheckedOut Book book) {
		tracker.setBookOwner(book, book.getOwner());
		tracker.setDueDate(book, new Date(System.currentTimeMillis() + 7*24*60*60*1000));
	}
}
