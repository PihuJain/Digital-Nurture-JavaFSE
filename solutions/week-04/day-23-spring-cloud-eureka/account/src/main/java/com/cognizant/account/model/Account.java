package com.cognizant.account.model;

// just a response shape, no jpa here, handout is explicit this service has no
// backend connectivity yet, its purely about proving service registration works
public class Account {

    private String number;

    private String type;

    private long balance;

    public Account(String number, String type, long balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public long getBalance() {
        return balance;
    }
}
