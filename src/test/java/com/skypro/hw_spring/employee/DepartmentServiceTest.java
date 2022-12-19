package com.skypro.hw_spring.employee;

import com.skypro.hw_spring.employee_app.model.Employee;
import com.skypro.hw_spring.employee_app.service.DepartmentService;
import com.skypro.hw_spring.employee_app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    Employee employee1 = new Employee("One", "One", 1, 2500);
    Employee employee2 = new Employee("Two", "Two", 1, 4000);
    Employee employee3 = new Employee("Three", "Three", 1, 7500);
    Employee employee4 = new Employee("Four", "Four", 2, 4000);

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        when(employeeService.getAllEmployees()).thenReturn(Set.of(employee1, employee2, employee3, employee4));
    }

    @Test
    void getDepartmentTest() {
        var actual = departmentService.getDepartment(1);
        assertEquals(3, actual.size());
        assertTrue(actual.containsAll(List.of(employee1, employee2, employee3)));
    }

    @Test
    void getSalarySumOneDepartmentTest() {
        assertEquals(14000, departmentService.getSalarySumOneDepartment(1));
    }

    @Test
    void getMaxSalaryInDepartmentTest() {
        assertEquals(7500, departmentService.getMaxSalaryInDepartment(1));
    }

    @Test
    void getMinSalaryInDepartmentTest() {
        assertEquals(2500, departmentService.getMinSalaryInDepartment(1));
    }

    @Test
    void getNumberOfDepartmentTest() {
        assertEquals(2, departmentService.getNumberOfDepartment());
    }

    @Test
    void getEmployeesSortedByDepartmentTest() {
        assertTrue(departmentService.getEmployeesSortedByDepartment().get(1)
                .containsAll(List.of(employee1, employee2, employee3)));
        assertTrue(departmentService.getEmployeesSortedByDepartment().get(2).contains(employee4));
    }
}