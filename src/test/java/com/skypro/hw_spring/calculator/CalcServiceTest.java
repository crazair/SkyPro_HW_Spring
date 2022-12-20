package com.skypro.hw_spring.calculator;

import com.skypro.hw_spring.calculator.exceptions.IllegalDivisionArgumentException;
import com.skypro.hw_spring.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcServiceTest {

    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void sumWithoutFirstArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.sum(null, 2));
    }

    @Test
    void sumWithoutSecondArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.sum(25, null));
    }

    @Test
    void differWithoutFirstArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.dif(null, 2));
    }

    @Test
    void differWithoutSecondArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.dif(25, null));
    }

    @Test
    void multWithoutFirstArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.mult(null, 2));
    }

    @Test
    void multWithoutSecondArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.mult(25, null));
    }

    @Test
    void divisionWithoutFirstArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(null, 2));
    }

    @Test
    void divisionWithoutSecondArgumentReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(25, null));
    }

    @Test
    void divisionByZeroReturnIllegalDivisionArgumentException() {
        assertThrows(IllegalDivisionArgumentException.class, () -> calculatorService.divide(25, 0));
    }
}
