package com.skypro.hw_spring.store_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class StoreService {

    private final List<Integer> productIds = new ArrayList<>();

    public void addProducts(List<Integer> productIds) {
        this.productIds.addAll(productIds);
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

}
