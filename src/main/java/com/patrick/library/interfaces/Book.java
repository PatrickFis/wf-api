package com.patrick.library.interfaces;

public interface Book {
	public String getBookId();
	public String getTitle();
	public String getInfo();
	public String getOwner();
	public void setOwner(String owner);
	public boolean getCheckedOut();
	public void checkout();
	public void returnBook();
}
