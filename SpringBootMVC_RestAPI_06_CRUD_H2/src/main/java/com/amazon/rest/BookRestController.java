package com.amazon.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.model.Book;
import com.amazon.service.BookService;

@RestController
public class BookRestController 
{
	
	//service interface injection 
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public ResponseEntity<String> welcomePage()
	{
		String resPayLoad="Hello Team welcome to Dev";
		return new ResponseEntity<String>(resPayLoad,HttpStatus.OK);
	}
	
	//insert new book 
	@PostMapping(value = "/book",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			   )
	public ResponseEntity<String> addNewBook(@RequestBody Book book)
	{
		String msg = bookService.upsertBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	//get All the books
	@GetMapping(value = "/books",
			      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} 
	            )
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> books = bookService.getAllBooks();	
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	//update the record
	@PutMapping(value = "/book",
			consumes ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public ResponseEntity<String> updateRecord(@RequestBody Book book)
	{
		String msg = bookService.upsertBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	//delete the record based on id
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteRecord(@PathVariable Integer bookId)
	{
		String msg = bookService.deleteBook(bookId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);	
	}
	
	
	

}
