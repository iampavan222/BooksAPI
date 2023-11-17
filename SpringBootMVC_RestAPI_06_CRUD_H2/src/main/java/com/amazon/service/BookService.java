package com.amazon.service;

import java.util.List;

import com.amazon.model.Book;

public interface BookService 
{
	//insert and update book
	public String upsertBook(Book book);

	//get All Book Details
	public List<Book> getAllBooks();

	//delete book based on bookId
	public String deleteBook(Integer bookId);

}
