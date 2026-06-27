package com.example;

import lombok.extern.slf4j.Slf4j;

// @Slf4j gives me a logger field called log without declaring it myself
// same slf4j logger as day 10, just generated instead of hand written
@Slf4j
public class PayrollService {

    public double annualSalary(Employee e) {
        log.info("working out annual salary for {}", e.getName());
        return e.getSalary() * 12;
    }
}
