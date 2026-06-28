package com.library.repository;

// the data layer. just an in-memory lookup for now, pretend its a db
public class BookRepository {

    public String getBookById(int id) {
        if (id == 1) {
            return "the pragmatic programmer";
        }
        return "unknown book";
    }
}
