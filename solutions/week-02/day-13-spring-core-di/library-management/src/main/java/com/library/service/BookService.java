package com.library.service;

import com.library.repository.BookRepository;

// day 13 - the repository actually gets injected now, and im doing both styles in one bean
// libraryName comes in through the constructor (constructor injection)
// repository comes in through a setter (setter injection)
public class BookService {

    private final String libraryName;
    private BookRepository repository;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String findBook(int id) {
        // service just delegates to whatever repository spring handed it
        return repository.getBookById(id);
    }
}
