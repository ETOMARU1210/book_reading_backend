package com.bezkoder.spring.security.postgresql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.models.Book;
import com.bezkoder.spring.security.postgresql.payload.request.BookRequest;
import com.bezkoder.spring.security.postgresql.payload.request.StatusCompleteRequest;
import com.bezkoder.spring.security.postgresql.security.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	public void addBooks(@RequestBody BookRequest bookRequest) {
		bookService.create(bookRequest);
	}
	
	@GetMapping("/all")
	public List<Book> allBooks(){
		return bookService.allBooks();
	}
	
	@GetMapping("/allunstatus")
	public List<Book> allUnStatusBooks(){
		return bookService.allUnStatusBooks("未読了");
	}
	
	
	@GetMapping("/allcompletestatus")
	public List<Book> allCompleteStatusBooks(){
		return bookService.allCompleteStatusBooks("読了");
	}
	
	@PostMapping("/statuscomplete")
	public void statusComplete(@RequestBody StatusCompleteRequest statusCompleteRequest) {
		bookService.statusCompleteUpdate(statusCompleteRequest);
	}

}
