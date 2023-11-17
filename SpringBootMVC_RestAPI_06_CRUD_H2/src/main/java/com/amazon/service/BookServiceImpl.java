package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.model.Book;
import com.amazon.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
   private BookRepository repository;
   
   
	@Override
	public String upsertBook(Book book) 
	{
		Integer id = book.getBookId();
	    System.out.println(book);
	    repository.save(book);
	    
	    if(id==null)
	    	return "Record Inserted";
	    else
		  return "Record Updated";
	}

	@Override
	public List<Book> getAllBooks() 
	{
		return repository.findAll();
	}

	@Override
	public String deleteBook(Integer bookId) 
	{
		repository.deleteById(bookId);
		return "Book deleted";
	}

}
