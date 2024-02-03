package com.bezkoder.spring.security.postgresql.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.security.postgresql.models.Book;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.payload.request.BookRequest;
import com.bezkoder.spring.security.postgresql.payload.request.StatusCompleteRequest;
import com.bezkoder.spring.security.postgresql.repository.BookRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;

	public void create(BookRequest bookRequest) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			if (bookRepository.existsByUserAndIsbn(user, bookRequest.getIsbn())) {
				return;
			}
		}
		
		Book book = new Book();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			User user = userRepository.findByUsername(username);
			book.setTitle(bookRequest.getTitle());
			book.setAuthor(bookRequest.getAuthor());
			book.setItemPrice(bookRequest.getItemPrice());
			book.setLargeImageUrl(bookRequest.getLargeImageUrl());
			book.setPublisherName(bookRequest.getPublisherName());
			book.setReviewAverage(bookRequest.getReviewAverage());
			book.setIsbn(bookRequest.getIsbn());
			book.setUser(user);
			book.setStatus(bookRequest.getStatus());
			bookRepository.save(book);
		} else {
			String username = principal.toString();
			User user = userRepository.findByUsername(username);
			book.setTitle(bookRequest.getTitle());
			book.setAuthor(bookRequest.getAuthor());
			book.setItemPrice(bookRequest.getItemPrice());
			book.setLargeImageUrl(bookRequest.getLargeImageUrl());
			book.setPublisherName(bookRequest.getPublisherName());
			book.setIsbn(bookRequest.getIsbn());
			book.setReviewAverage(bookRequest.getReviewAverage());
			book.setUser(user);
			bookRepository.save(book);
		}
	}

	public List<Book> allUnStatusBooks(String status) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUserAndStatus(user, status);
			return allBooks;
		} else {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUserAndStatus(user, status);
			return allBooks;
		}
	}

	public List<Book> allCompleteStatusBooks(String status) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUserAndStatus(user, status);
			return allBooks;
		} else {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUserAndStatus(user, status);
			return allBooks;
		}
	}

	public void statusCompleteUpdate(StatusCompleteRequest statusCompleteRequest) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			Book statusUpdateBook = bookRepository.findByUserAndIsbn(user, statusCompleteRequest.getIsbn());
			statusUpdateBook.setStatus("読了");
			bookRepository.save(statusUpdateBook);
		}
	}

	public List<Book> allBooks() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUser(user);
			return allBooks;
		} else {
			long userId = ((UserDetailsImpl) principal).getId();
			Optional<User> user = userRepository.findById(userId);
			List<Book> allBooks = bookRepository.findByUser(user);
			return allBooks;
		}
	}
}