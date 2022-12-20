package com.skypro.hw_spring.calculator.controller;

import com.skypro.hw_spring.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getHello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d + %d = %d", a, b, calculatorService.sum(a, b));
    }

    @GetMapping("/minus")
    public String dif(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d - %d = %d", a, b, calculatorService.dif(a, b));
    }

    @GetMapping("/multiply")
    public String mult(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d * %d = %d", a, b, calculatorService.mult(a, b));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d / %d = %d", a, b, calculatorService.divide(a, b));
    }
}