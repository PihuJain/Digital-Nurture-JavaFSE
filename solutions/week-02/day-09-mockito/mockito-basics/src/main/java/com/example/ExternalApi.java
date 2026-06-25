package com.example;

// the external dependency we dont want to actually hit in a unit test
// in real life this might be a network call or a db, here we just mock it
public interface ExternalApi {

    String getData();

    void saveData(String value);
}
