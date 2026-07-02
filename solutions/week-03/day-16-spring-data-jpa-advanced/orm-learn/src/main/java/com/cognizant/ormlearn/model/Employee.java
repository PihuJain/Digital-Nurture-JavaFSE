package com.cognizant.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double salary;

    private boolean permanent;

    // many to one is eager by default per the jpa spec, so fetching an employee
    // also pulls the department in the same go - no separate lazy load needed here
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name, double salary, boolean permanent) {
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        // deliberately not printing department here, department's toString doesnt
        // touch employees either - print both together and youd get a stack overflow
        // going back and forth between the two
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary
                + ", permanent=" + permanent + "}";
    }
}
