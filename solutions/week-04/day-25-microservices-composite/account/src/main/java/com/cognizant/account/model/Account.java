package com.cognizant.account.model;

// just a response shape, no jpa here, handout is explicit this service has no
// backend connectivity yet, its purely about proving service registration works
public class Account {

    private String number;

    private String type;

    private long balance;

    // not in the original handout response, added this for today only so the gateway
    // load balancing demo actually has something to point at - without it every
    // response looks identical and you cant tell which instance answered
    private String servedBy;

    public Account(String number, String type, long balance, String servedBy) {
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.servedBy = servedBy;
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

    public String getServedBy() {
        return servedBy;
    }
}
