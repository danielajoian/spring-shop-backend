package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductStoreService {

    private List<Product> products;
    private int id = 6;

    {
        products = new ArrayList<>(Arrays.asList(
            new Product(
                1,
                "Gem",
                "Gem de prune",
                ProductCategory.HOUSEHOLD,
                10.5,
                "https://www.reteteculinare.ro/assets/files/recipe/3453/fdb_1475477580_gem_de_prune_brumarii_bistrite_35384_3453.jpg",
                1

            ),
            new Product(
                2,
                "iPhone 30 XXL",
                "Biggest iPhone",
                ProductCategory.ELECTRONICS,
                2000.99,
                "https://i.pinimg.com/originals/15/a1/4b/15a14b04dd90345469551d06f36993e4.jpg",
                2

            ),
            new Product(
                3,
                "Zidane's Adidas cleats",
                "Size 43, Worn by Zidane",
                ProductCategory.SPORTS,
                1300.9,
                "https://i.pinimg.com/originals/eb/4f/41/eb4f41d38c19fa4048ccd2704f860934.jpg",
                2

            ),
            new Product(
                4,
                "Vila Poiana Brasov",
                "2000mp, curte mare, jacuzzi, piscina, sala sport proprie, balta pt pescuit",
                ProductCategory.ESTATE,
                500_000.99,
                "https://cf.bstatic.com/images/hotel/max1024x768/178/17815433.jpg",
                3
            ),
            new Product(
                5,
                "Vila Sinaia",
                "500mp, balta pt pescuit",
                ProductCategory.ESTATE,
                50_000.99,
                "https://cf.bstatic.com/images/hotel/max1024x768/176/176568097.jpg",
                3

            ),
            new Product(
                6,
                "Vila Cluj",
                "2000mp, curte mare, jacuzzi, piscina, sala sport proprie, femeia vine la pachet",
                ProductCategory.ESTATE,
                800_000.99,
                "https://i.ytimg.com/vi/ddAsqtxnHF0/maxresdefault.jpg",
                3
            )
        ));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream()
            .filter(p -> p.getId() == productId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " not found"));
    }

    public Product addProduct(Product product) {
        product.setId(++id);
        product.setUserId(0);
        return product;
    }
}
