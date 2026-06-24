package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

// parameterized tests (optional) - same check run against a bunch of inputs
// instead of writing one @Test per number which gets old fast
class EvenCheckerTest {

    private final EvenChecker checker = new EvenChecker();

    // @ValueSource feeds each int in one at a time, all of these should come back even
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 0, 100, -8})
    void evenNumbersReturnTrue(int number) {
        assertTrue(checker.isEven(number));
    }

    // @CsvSource for when you want the input and the expected result paired up
    @ParameterizedTest
    @CsvSource({"3, false", "6, true", "7, false", "10, true"})
    void checksAgainstExpected(int number, boolean expected) {
        assertEquals(expected, checker.isEven(number));
    }
}
