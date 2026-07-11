package com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableDiscoveryClient used to be required here but spring cloud auto-detects the
// eureka client dependency on the classpath and registers automatically now, adding
// it explicitly would just be a redundant annotation
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
