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
        new Product(
            1,
            "Gem",
            "Gem de prune",
            ProductCategory.HOUSEHOLD,
            10.5,
            ""
        ),
        new Product(
            2,
            "iPhone 15 XXL",
            "Biggest iphone",
            ProductCategory.ELECTRONICS,
            2000.99,
            ""
        ),
        new Product(
            3,
            "Adidas cleats",
            "Size 45, worn only once, decided they're not suited to my style",
            ProductCategory.SPORTS,
            130.9,
            ""
        ),
        new Product(
            4,
            "Vila Poiana Brasov",
            "2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit",
            ProductCategory.ESTATE,
            500_000.99,
            ""
        ),
        new Product(
            5,
            "Vila Poiana Brasov",
            "2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit",
            ProductCategory.ESTATE,
            500_000.99,
            ""
        ),
        new Product(
            6,
            "Vila Poiana Brasov",
            "2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit",
            ProductCategory.ESTATE,
            500_000.99,
            ""
        )
    ));

    public List<Product> getProducts() {
        return products;
    }
}
