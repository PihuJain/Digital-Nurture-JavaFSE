package com.library.service;

// service layer. standalone for now, day 13 is where BookRepository actually gets wired into it
public class BookService {

    public String describe() {
        return "library book service is up";
    }
}
