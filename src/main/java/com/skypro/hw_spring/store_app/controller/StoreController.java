package com.skypro.hw_spring.store_app.controller;

import com.skypro.hw_spring.store_app.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/order/add")
    public List<Integer> addProduct(@RequestBody List<Integer> productIds) {
        storeService.addProducts(productIds);
        productIds.stream().forEach(System.out::println);
        return productIds;
    }

    @GetMapping("/order/get")
    public List<Integer> getAllEmployees() {
        return storeService.getProductIds();
    }

}
