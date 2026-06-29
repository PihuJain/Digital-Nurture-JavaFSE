package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// the whole point of ex9 - one annotation and boot auto-configures the web server, the
// datasource, jpa, all of it. compared to the xml context wiring on day 12 this is nothing
@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }
}
