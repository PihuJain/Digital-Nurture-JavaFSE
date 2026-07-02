package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // HQL - looks like sql but its Employee the java class and e.permanent the field,
    // not the employee table or a permanent column directly. hibernate translates it
    @Query(value = "SELECT e FROM Employee e WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // straight sql this time, nativeQuery=true tells spring data to skip hql entirely
    // and just run this against the database as-is
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
