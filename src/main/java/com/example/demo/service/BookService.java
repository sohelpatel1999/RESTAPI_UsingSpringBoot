package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;

@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(1,"java part 1", "Sohel"));
		list.add(new Book(2,"java part 2", "Akhil"));
		list.add(new Book(3,"Go part 1", "syed"));
	}
	
	public List<Book> GetAllBook() {
		return list;
	}
	
	//Get Single book
	public Book getBookById(int id){
		Book book = null;
		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
		
	}
	
	public Book addBook(Book book) {
		
		list.add(book);
		return book;
	}
	
	public List<Book> deleteBook(int bookid) {
		
		list = list.stream().filter(e->e.getId()!=bookid).collect(Collectors.toList());
		return list;
	}

	public void updateBook(Book book, int bookid) {
		
		list.stream().map(b->{
			if(b.getId()==bookid) {
				b.setId(book.getId());
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());
		
		
	}

}
