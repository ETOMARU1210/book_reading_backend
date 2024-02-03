package com.bezkoder.spring.security.postgresql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.security.postgresql.models.Book;
import com.bezkoder.spring.security.postgresql.models.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByUserAndStatus(Optional<User> user, String Status);
	Book findByUserAndIsbn(Optional<User> user, String isbn);
	Boolean existsByUserAndIsbn(Optional<User> user, String isbn);
	List<Book> findByUser(Optional<User> user);
}
