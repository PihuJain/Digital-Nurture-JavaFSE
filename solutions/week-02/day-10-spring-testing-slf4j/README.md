day 10 - spring testing + slf4j
june 26

slf4j logging was the mandatory one. did an @InjectMocks test as the optional - the full
@SpringBootTest integration version makes more sense once we actually have spring set up
(thats the spring core days), so kept it to the mockito side for now

slf4j (LoggingExample)
slf4j is just the logging api, logback is the thing on the classpath that actually writes
anything out. logged at error/warn/info/debug. used parameterized logging too, like
logger.info("user {} logged in", user) - better than string concat because it only builds
the string if that level is even turned on. added a logback.xml with a console and a file
appender so the same lines go to the terminal and to app.log

testing logging was the bit that made me think. you cant really assert on console output, so
i hooked a logback ListAppender onto the logger, ran the code, then checked the captured
events had an error and a warn in them. bit hacky but at least its a real assertion

@injectmocks (OrderService)
carries on from day 9. instead of newing up the service and passing the mock in by hand,
@Mock + @InjectMocks + the MockitoExtension wires it all together. less boilerplate

