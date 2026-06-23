package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// first proper junit tests. one test method per thing i wanted to check
// the @Test annotation is what tells junit "run this", surefire picks them up by it
class CalculatorTest {

    @Test
    void addsTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractGivesTheDifference() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(4, 3));
    }

    @Test
    void multiplyWorks() {
        Calculator calc = new Calculator();
        assertEquals(12, calc.multiply(3, 4));
    }
}
