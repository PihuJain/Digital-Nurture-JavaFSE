package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// rest controller for the book crud - this is the new bit ex9 adds over the plain jpa layer
// @RestController means every method returns json straight back, no view layer
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> all() {
        return repository.findAll();
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/{id}")
    public Book one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
