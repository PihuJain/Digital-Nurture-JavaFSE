package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class EmployeeDepartmentTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void employeeCarriesItsDepartment() {
        Department engineering = departmentRepository.save(new Department("Engineering"));

        Employee employee = new Employee("Riya", 55000.0, true);
        employee.setDepartment(engineering);
        Employee saved = employeeService.save(employee);

        // many to one is eager by default, so this should already have the
        // department populated without a second query
        assertNotNull(saved.getDepartment());
        assertEquals("Engineering", saved.getDepartment().getName());
    }

    @Test
    void hqlFindsOnlyPermanentEmployees() {
        Department support = departmentRepository.save(new Department("Support"));

        Employee permanentOne = new Employee("Aman", 40000.0, true);
        permanentOne.setDepartment(support);
        employeeService.save(permanentOne);

        Employee contractor = new Employee("Zoya", 35000.0, false);
        contractor.setDepartment(support);
        employeeService.save(contractor);

        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployees();
        assertEquals(1, permanentEmployees.size());
        assertEquals("Aman", permanentEmployees.get(0).getName());
    }

    @Test
    void nativeQueryReturnsEveryEmployeeRegardlessOfStatus() {
        Employee employee = new Employee("Kabir", 42000.0, false);
        employeeService.save(employee);

        List<Employee> all = employeeService.getAllEmployeesNative();
        assertEquals(1, all.size());
    }
}
