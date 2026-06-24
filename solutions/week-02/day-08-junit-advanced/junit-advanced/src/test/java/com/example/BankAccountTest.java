package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// AAA pattern + fixtures (exercise 4)
// @BeforeEach runs before every test so each one gets a fresh account
// thats the point of fixtures, no leftover state leaking from the last test
class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // the arrange step that every test needs, pulled out here
        account = new BankAccount(100.0);
    }

    @AfterEach
    void tearDown() {
        // nothing real to clean up here, but this is where youd close a file or a db connection
        account = null;
    }

    @Test
    void depositAddsToBalance() {
        // arrange done in setUp, account starts at 100
        // act
        account.deposit(50.0);
        // assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawTakesFromBalance() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void withdrawingTooMuchThrows() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(500.0));
    }
}
