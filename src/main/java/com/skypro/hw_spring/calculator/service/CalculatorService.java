package com.skypro.hw_spring.calculator.service;

import com.skypro.hw_spring.calculator.exceptions.IllegalDivisionArgumentException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Integer sum(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Должно быть два числа");
        }
        return a + b;
    }

    public Integer dif(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Должно быть два числа");
        }
        return a - b;
    }

    public Integer mult(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Должно быть два числа");
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Должно быть два числа");
        }
        if (b == 0) {
            throw new IllegalDivisionArgumentException("Делитель не может быть равен 0");
        } //по условию нужно выбрасывать собственного наследника класса IllegalArgumentException
        return a / b;
    }
}
