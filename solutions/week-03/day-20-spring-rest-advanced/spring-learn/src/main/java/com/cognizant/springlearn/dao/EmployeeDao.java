package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private final List<Employee> employeeList;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        this.employeeList = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // finds the matching employee by id and replaces its fields in place rather than
    // swapping the list entry out, keeps the same object reference in the list
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        for (Employee existing : employeeList) {
            if (existing.getId().equals(employee.getId())) {
                existing.setName(employee.getName());
                existing.setSalary(employee.getSalary());
                existing.setPermanent(employee.getPermanent());
                existing.setDateOfBirth(employee.getDateOfBirth());
                return;
            }
        }
        throw new EmployeeNotFoundException("employee not found for id " + employee.getId());
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        boolean removed = employeeList.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException("employee not found for id " + id);
        }
    }
}
