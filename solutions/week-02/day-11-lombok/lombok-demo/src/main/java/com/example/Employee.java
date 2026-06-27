package com.example;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

// lombok generates the getters, the builder and toString from these annotations at compile
// time, so no boilerplate by hand. @Builder gives the same chained style i wrote out in full
// for the Computer class back on day 1, except lombok does all of it
@Getter
@Builder
@ToString
public class Employee {

    private String name;
    private String department;
    private double salary;
}
