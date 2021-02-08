package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductStoreService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
        new Product("Gem", "Gem de prune", ProductCategory.HOUSEHOLD, 10.5),
        new Product("iPhone 15 XXL", "Biggest iphone", ProductCategory.ELECTRONICS, 2000.99)
    ));

    public List<Product> getProducts() {
        return products;
    }
}
