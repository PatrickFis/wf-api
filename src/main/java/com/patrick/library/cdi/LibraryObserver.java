package com.patrick.library.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;

import com.patrick.library.interfaces.Book;

@Singleton
public class LibraryObserver {
	private static final Logger logger = Logger.getLogger("book");
	
	public void bookAdded(@Observes @BookAdded Book book) {
		logger.log(Level.INFO, "Book added, ID: {0}, Title: {1}, Checked Out: {2}", new Object[] {book.getBookId(), book.getTitle(), book.getCheckedOut()});
	}
}
