package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// slf4j exercise - logging at the different levels
// slf4j is only the api, logback (on the classpath) is what actually writes the logs
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public void doStuff(String user) {
        // parameterized logging - the {} gets swapped for the arg
        // nicer than "user " + user because the string only gets built if that level is on
        logger.info("user {} logged in", user);
        logger.debug("debug detail for {}", user);
        logger.warn("this is a warning");
        logger.error("this is an error message");
    }

    public static void main(String[] args) {
        new LoggingExample().doStuff("pihu");
    }
}
