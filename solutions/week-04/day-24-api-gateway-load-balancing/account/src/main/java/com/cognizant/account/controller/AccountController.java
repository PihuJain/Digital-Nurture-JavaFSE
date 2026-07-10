package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    // just the port this particular instance is running on, so when two copies of
    // this service are both registered as "account-service" you can tell them apart
    // in the response instead of every instance looking identical
    @Value("${server.port}")
    private String port;

    // dummy data straight back, same account type regardless of number for now -
    // the point of this exercise is proving the service registers with eureka,
    // not building out real account lookups
    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        return new Account(number, "savings", 234343, "account-service:" + port);
    }
}
