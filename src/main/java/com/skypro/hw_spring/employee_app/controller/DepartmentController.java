package com.skypro.hw_spring.employee_app.controller;

import com.skypro.hw_spring.employee_app.model.Employee;
import com.skypro.hw_spring.employee_app.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getDepartment(@PathVariable("id") int id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOneDepartment(@PathVariable("id") int id) {
        return departmentService.getSalarySumOneDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryInDepartment(@PathVariable("id") int id) {
        return departmentService.getMaxSalaryInDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalaryInDepartment(@PathVariable("id") int id) {
        return departmentService.getMinSalaryInDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesSortedByDepartment() {
        return departmentService.getEmployeesSortedByDepartment();
    }

}