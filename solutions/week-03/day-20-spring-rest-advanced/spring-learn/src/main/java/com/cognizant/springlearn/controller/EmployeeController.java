package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("start");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.info("end");
        return employees;
    }

    // @Valid triggers GlobalExceptionHandler.handleMethodArgumentNotValid if the
    // payload fails any of the constraints on Employee
    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("start");
        employeeService.updateEmployee(employee);
        LOGGER.info("end");
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
        LOGGER.info("start");
        employeeService.deleteEmployee(id);
        LOGGER.info("end");
    }
}
