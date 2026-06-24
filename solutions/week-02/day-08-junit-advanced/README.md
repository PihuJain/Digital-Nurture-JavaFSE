day 8 - junit5 advanced
june 24

mandatory was the AAA pattern + fixtures one, did parameterized tests as the optional

aaa + fixtures (BankAccount)
made a little BankAccount with deposit/withdraw so theres actual state to test against. the
AAA bit is just arrange-act-assert, every test set up the thing, do the action, check the
result. fixtures are the @BeforeEach/@AfterEach methods - BeforeEach spins up a fresh account
before every single test so nothing leaks from one test into the next. learnt that one the
hard way before, shared state between tests is a pain to debug. AfterEach is where youd close
a db connection or a file, didnt really need it here so just nulled the account out

parameterized (EvenChecker)
this is the good one. instead of one isEven test per number you write it once and feed it a
list. @ValueSource for a plain list of ints, @CsvSource when you want the input and the
expected answer paired up like "6, true". surefire counts each input as its own test so the
2 parameterized methods turned into 9 actual runs

