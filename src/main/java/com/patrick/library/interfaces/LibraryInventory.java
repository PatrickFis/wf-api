package com.patrick.library.interfaces;

import java.util.List;

public interface LibraryInventory {
	public List<Book> getBooks();
	public void checkOutBook(String bookId);
	public void returnBook(String bookId);
	public void generateDefaultData();
	public void addBook(Book book);
}
