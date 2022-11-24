package com.skypro.hw_spring.employee_app.controller;

import com.skypro.hw_spring.employee_app.service.EmployeeService;
import com.skypro.hw_spring.employee_app.model.Employee;
import com.skypro.hw_spring.employee_app.record.EmployeeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            return employeeService.addEmployee(employeeRequest);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Фамилия/имя должны быть заполнены!", e);
        }
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public List<Employee> getMinSalary() {
        return employeeService.getMinSalaryEmployees();
    }

    @GetMapping("/employee/salary/max")
    public List<Employee> getMaxSalary() {
        return employeeService.getMaxSalaryEmployees();
    }

    @GetMapping("/employee/high-salary")
    public List<Employee> getHighSalary() {
        return employeeService.getHighSalary();
    }

}