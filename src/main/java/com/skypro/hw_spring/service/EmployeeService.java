package com.skypro.hw_spring.service;

import com.skypro.hw_spring.model.Employee;
import com.skypro.hw_spring.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Имя/фамилия должны быть заполнены!");
        }

        Employee employee = new Employee(employeeRequest.getLastName(),
                employeeRequest.getLastName(), employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        employees.put(employee.getId(), employee);

        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getMinSalary() {
        return employees.values().stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public int getMaxSalary() {
        return employees.values().stream()
                .map(Employee::getSalary)
                .max(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public List<Employee> getMinSalaryEmployees() {
        int minSalary = getMinSalary();
        return employees.values().stream()
                .filter(e -> e.getSalary() == minSalary)
                .collect(Collectors.toList());
    }

    public List<Employee> getMaxSalaryEmployees() {
        int maxSalary = getMaxSalary();
        return employees.values().stream()
                .filter(e -> e.getSalary() == maxSalary)
                .collect(Collectors.toList());
    }

    public int getAverage() {
        return (int) employees.values().stream()
                .mapToInt(Employee::getSalary)
                .average().orElseGet(() -> 0);
    }

    public List<Employee> getHighSalary() {
        int averageSalary = getAverage();
        return employees.values().stream()
                .filter(e -> e.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }
}