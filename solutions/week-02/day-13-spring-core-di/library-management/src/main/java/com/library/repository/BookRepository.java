package com.library.repository;

// same data layer as day 12, today it actually gets injected into the service
public class BookRepository {

    public String getBookById(int id) {
        if (id == 1) {
            return "the pragmatic programmer";
        }
        return "unknown book";
    }
}
