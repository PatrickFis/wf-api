package com.patrick.library.books;

import com.patrick.library.interfaces.Book;

public class BookImpl implements Book {
	
	private String bookId;
	private String title;
	private boolean checkedOut;
	
	public BookImpl(String bookId, String title, boolean checkedOut) {
		this.bookId = bookId;
		this.title = title;
		this.checkedOut = checkedOut;
	}
	
	@Override
	public String getBookId() {
		return this.bookId;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public boolean getCheckedOut() {
		return this.checkedOut;
	}

	@Override
	public void checkout() {
		this.checkedOut = true;
	}

	@Override
	public void returnBook() {
		this.checkedOut = false;
	}

}
