package com.cognizant.ormlearn.service.exception;

// thrown when a lookup by code comes up empty, service layer decides what
// counts as "not found" not the repository
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(String message) {
        super(message);
    }
}
