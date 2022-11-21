package com.skypro.hw_spring.model;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static int count;
    private final int id;
    private String firstName;
    private String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String middleName, int department, int salary) {
        setFirstName(firstName);
        setLastName(middleName);
        this.department = department;
        this.salary = salary;

        id = ++count;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isEmpty(firstName)) {
            throw new IllegalArgumentException("Имя должно быть заполнено!");
        }
        this.firstName = StringUtils.toRootUpperCase(firstName);
    }

    public void setLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            throw new IllegalArgumentException("Фамилия должна быть заполнена!");
        }
        this.lastName = StringUtils.toRootUpperCase(lastName);
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}