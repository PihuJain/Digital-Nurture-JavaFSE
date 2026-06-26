package com.example;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

// to actually test logging i hook a logback ListAppender onto the logger and check what it
// captured. otherwise youre just squinting at console output which isnt really a test
class LoggingExampleTest {

    @Test
    void logsAtTheExpectedLevels() {
        Logger logbackLogger = (Logger) LoggerFactory.getLogger(LoggingExample.class);
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.start();
        logbackLogger.addAppender(appender);

        new LoggingExample().doStuff("pihu");

        // walk the captured events, make sure the error and warn ones came through
        boolean hasError = false;
        boolean hasWarn = false;
        for (ILoggingEvent event : appender.list) {
            if (event.getLevel() == Level.ERROR) {
                hasError = true;
            }
            if (event.getLevel() == Level.WARN) {
                hasWarn = true;
            }
        }
        assertTrue(hasError);
        assertTrue(hasWarn);
    }
}
