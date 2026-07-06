package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private final List<Department> departmentList;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        this.departmentList = (List<Department>) context.getBean("departmentList");
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
