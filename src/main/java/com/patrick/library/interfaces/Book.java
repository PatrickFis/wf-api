package com.patrick.library.interfaces;

public interface Book {
	public String getBookId();
	public String getTitle();
	public boolean getCheckedOut();
	public void checkout();
	public void returnBook();
}
