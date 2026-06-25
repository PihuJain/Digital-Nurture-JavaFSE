package com.example;

// service under test. takes the api in through the constructor so a mock can be swapped in
public class MyService {

    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void backup(String value) {
        api.saveData(value);
    }
}
