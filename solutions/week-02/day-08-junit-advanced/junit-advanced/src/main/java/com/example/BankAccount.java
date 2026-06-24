package com.example;

// little account class for the fixtures + AAA exercise
// needs some state to set up and tear down so the tests have something real to act on
public class BankAccount {

    private double balance;

    public BankAccount(double opening) {
        this.balance = opening;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
