package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {

//	@GetMapping(value = "/books")
//	public Book getBooks() {
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("java is love");
//		book.setAuthor("Sohel");
//		System.out.println(book);
//		return book;

//	}
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/books")
	public List<Book> getBooks() {
		
		return this.bookService.GetAllBook();

	}
	
	@GetMapping(value = "/books/{id}")
	public Book getBookById(@PathVariable("id") int id){
		
		return bookService.getBookById(id);
		
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		
		Book b = bookService.addBook(book);
		return b;
		
	}
	@DeleteMapping("/books/{bookid}")
	public List<Book> deleteBook(@PathVariable("bookid") int bookid){
		return this.bookService.deleteBook(bookid);
	}
	@PutMapping("/books/{bookid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookid") int bookid) {
		
		this.bookService.updateBook(book,bookid);
		return book;
	}

}
