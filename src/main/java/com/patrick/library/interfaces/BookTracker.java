package com.patrick.library.interfaces;

import java.util.Date;
import java.util.List;

public interface BookTracker {
	public String getOwner(Book book);
	public Date getDueDate(Book book);
	public List<Book> getOverdueBooks();
	public double calculateLateFees(Book book);
	public void setDueDate(Book book, Date dueDate);
	public void removeDueDate(Book book);
	public void setBookOwner(Book book, String owner);
	public void removeBookOwner(Book book);
}
