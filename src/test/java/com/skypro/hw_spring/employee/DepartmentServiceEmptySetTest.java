package com.skypro.hw_spring.employee;

import com.skypro.hw_spring.employee_app.service.DepartmentService;
import com.skypro.hw_spring.employee_app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceEmptySetTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        when(employeeService.getAllEmployees()).thenReturn(Set.of());
    }

    @Test
    void getDepartmentTest() {
        var actual = departmentService.getDepartment(1);
        assertEquals(0, actual.size());
        assertTrue(actual.isEmpty());
    }

    @Test
    void getSalarySumOneDepartmentTest() {
        assertEquals(0, departmentService.getSalarySumOneDepartment(1));
    }

    @Test
    void getMaxSalaryInDepartmentTest() {
        assertEquals(0, departmentService.getMaxSalaryInDepartment(1));
    }

    @Test
    void getMinSalaryInDepartmentTest() {
        assertEquals(0, departmentService.getMinSalaryInDepartment(1));
    }

    @Test
    void getNumberOfDepartmentTest() {
        assertEquals(0, departmentService.getNumberOfDepartment());
    }

    @Test
    void getEmployeesSortedByDepartmentTest() {
        assertTrue(departmentService.getEmployeesSortedByDepartment().isEmpty());
    }
}