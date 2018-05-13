package com.patrick.library.books;

import com.patrick.library.interfaces.Book;

public class BookImpl implements Book {
	
	private String bookId;
	private String title;
	private String info;
	private String owner;
	private boolean checkedOut;
	
	public BookImpl(String bookId, String title, String info, String owner, boolean checkedOut) {
		this.bookId = bookId;
		this.title = title;
		this.info = info;
		this.owner = owner;
		this.checkedOut = checkedOut;
	}
	
	public BookImpl(String bookId, String title, String info, boolean checkedOut) {
		this(bookId, title, info, null, checkedOut);
	}
	
	@Override
	public String getBookId() {
		return this.bookId;
	}
	
	@Override
	public String getInfo() {
		return this.info;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getOwner() {
		return this.owner;
	}
	
	@Override
	public void setOwner(String owner) {
		this.owner = owner;
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
