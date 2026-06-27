package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// checking the lombok generated builder and getters actually work, and the @Slf4j logger
// in PayrollService doesnt blow up
class EmployeeTest {

    @Test
    void builderSetsTheFields() {
        Employee e = Employee.builder()
                .name("pihu")
                .department("engineering")
                .salary(5000.0)
                .build();

        assertEquals("pihu", e.getName());
        assertEquals("engineering", e.getDepartment());
        assertEquals(5000.0, e.getSalary());
    }

    @Test
    void annualSalaryIsTwelveMonths() {
        Employee e = Employee.builder().name("x").department("y").salary(1000.0).build();
        PayrollService service = new PayrollService();
        assertEquals(12000.0, service.annualSalary(e));
    }
}
