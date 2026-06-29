package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// same free crud as the day 14 country one, JpaRepository gives save/findAll/findById
public interface BookRepository extends JpaRepository<Book, Long> {
}
