package com.example;

// small class to write the first junit tests against
// kept the methods obvious on purpose, the point here is learning junit not the maths
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // wanted one method that can actually blow up so theres something to test
    // the exception path with later
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("cannot divide by zero");
        }
        return a / b;
    }
}
